package top.itning.tmpp.tmppadmin.service.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.itning.tmpp.tmppadmin.mapper.AdminResourceMapper;
import top.itning.tmpp.tmppadmin.mapper.AdminUserRoleMapper;
import top.itning.tmpp.tmppadmin.mapper.AdminUserRoleResourceMapper;
import top.itning.tmpp.tmppadmin.pojo.*;
import top.itning.tmpp.tmppadmin.service.AdminResourceService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author itning
 * @date 2019/6/17 15:00
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminResourceServiceImpl implements AdminResourceService {
    private final AdminResourceMapper adminResourceMapper;
    private final ModelMapper modelMapper;
    private final AdminUserRoleMapper adminUserRoleMapper;
    private final AdminUserRoleResourceMapper adminUserRoleResourceMapper;

    @Autowired
    public AdminResourceServiceImpl(AdminResourceMapper adminResourceMapper, ModelMapper modelMapper, AdminUserRoleMapper adminUserRoleMapper, AdminUserRoleResourceMapper adminUserRoleResourceMapper) {
        this.adminResourceMapper = adminResourceMapper;
        this.modelMapper = modelMapper;
        this.adminUserRoleMapper = adminUserRoleMapper;
        this.adminUserRoleResourceMapper = adminUserRoleResourceMapper;
    }

    @Override
    public List<AdminResourceWithRoles> getAllAdminResources() {
        return adminResourceMapper.selectAll().stream().sorted((o1, o2) -> {
            if (o1.getGmtModified().before(o2.getGmtModified())) {
                return 1;
            } else if (o1.getGmtModified().after(o2.getGmtModified())) {
                return -1;
            } else {
                return 0;
            }
        }).map(adminResource -> {
            AdminResourceWithRoles adminResourceWithRoles = modelMapper.map(adminResource, AdminResourceWithRoles.class);
            List<AdminUserRole> adminUserRoleResources = adminUserRoleMapper.selectByResourceId(adminResource.getId());
            adminResourceWithRoles.setRoles(adminUserRoleResources);
            return adminResourceWithRoles;
        }).collect(Collectors.toList());
    }

    @Override
    public AdminResource getAdminResourceById(String id) {
        return adminResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveAdminResource(String url, String method, int[] roles) {
        String id = UUID.randomUUID().toString().replace("-", "");
        AdminResource adminResource = new AdminResource();
        adminResource.setId(id);
        adminResource.setUrl(url);
        adminResource.setMethod(method.toUpperCase());
        adminResource.setGmtCreate(new Date());
        adminResource.setGmtModified(new Date());
        adminResourceMapper.insert(adminResource);
        Date date = new Date();
        List<Integer> adminUserRoleResources = adminUserRoleResourceMapper.selectUserRoleByResourceId(id);
        for (int role : roles) {
            if (adminUserRoleResources.contains(role)) {
                continue;
            }
            AdminUserRoleResource adminUserRoleResource = new AdminUserRoleResource();
            adminUserRoleResource.setGmtCreate(date);
            adminUserRoleResource.setGmtModified(date);
            adminUserRoleResource.setUserRoleId(role);
            adminUserRoleResource.setResourceId(id);
            adminUserRoleResourceMapper.insert(adminUserRoleResource);
        }
    }

    @Override
    public void delAdminResource(String id) {
        adminResourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void upAdminResource(String id, String newUrl, String newMethod, int[] roles) {
        AdminResource adminResource = new AdminResource();
        adminResource.setId(id);
        adminResource.setUrl(newUrl);
        adminResource.setMethod(newMethod.toUpperCase());
        adminResource.setGmtModified(new Date());
        adminResourceMapper.updateByPrimaryKeySelective(adminResource);

        Date date = new Date();
        List<Integer> adminUserRoleResources = adminUserRoleResourceMapper.selectUserRoleByResourceId(id);
        adminUserRoleMapper.selectAll().forEach(adminUserRole -> {
            if (ArrayUtils.contains(roles, adminUserRole.getId())) {
                if (!adminUserRoleResources.contains(adminUserRole.getId())) {
                    AdminUserRoleResource adminUserRoleResource = new AdminUserRoleResource();
                    adminUserRoleResource.setGmtCreate(date);
                    adminUserRoleResource.setGmtModified(date);
                    adminUserRoleResource.setUserRoleId(adminUserRole.getId());
                    adminUserRoleResource.setResourceId(id);
                    adminUserRoleResourceMapper.insert(adminUserRoleResource);
                }
            } else {
                adminUserRoleResourceMapper.deleteByPrimaryKey(new AdminUserRoleResourceKey(adminUserRole.getId(), id));
            }
        });
    }
}
