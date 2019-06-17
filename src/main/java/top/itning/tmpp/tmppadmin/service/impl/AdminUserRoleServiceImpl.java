package top.itning.tmpp.tmppadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.itning.tmpp.tmppadmin.mapper.AdminUserRoleMapper;
import top.itning.tmpp.tmppadmin.pojo.AdminUserRole;
import top.itning.tmpp.tmppadmin.service.AdminUserRoleService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author itning
 * @date 2019/6/17 16:57
 */
@Service
public class AdminUserRoleServiceImpl implements AdminUserRoleService {
    private final AdminUserRoleMapper adminUserRoleMapper;

    @Autowired
    public AdminUserRoleServiceImpl(AdminUserRoleMapper adminUserRoleMapper) {
        this.adminUserRoleMapper = adminUserRoleMapper;
    }

    @Override
    public List<AdminUserRole> getAdminUserRoleByResourceId(String resourceId) {
        return adminUserRoleMapper.selectByResourceId(resourceId).stream().filter(adminUserRole -> !"ADMIN".equals(adminUserRole.getType())).collect(Collectors.toList());
    }

    @Override
    public List<AdminUserRole> getAdminUserRoles() {
        return adminUserRoleMapper.selectAll().stream().filter(adminUserRole -> !"ADMIN".equals(adminUserRole.getType())).collect(Collectors.toList());
    }
}
