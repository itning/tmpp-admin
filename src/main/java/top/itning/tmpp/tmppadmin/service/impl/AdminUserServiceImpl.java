package top.itning.tmpp.tmppadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.itning.tmpp.tmppadmin.mapper.AdminUserMapper;
import top.itning.tmpp.tmppadmin.mapper.AdminUserRoleMapper;
import top.itning.tmpp.tmppadmin.pojo.AdminUser;
import top.itning.tmpp.tmppadmin.service.AdminUserService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author itning
 * @date 2019/6/17 17:58
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    private final AdminUserMapper adminUserMapper;
    private final AdminUserRoleMapper adminUserRoleMapper;

    @Autowired
    public AdminUserServiceImpl(AdminUserMapper adminUserMapper, AdminUserRoleMapper adminUserRoleMapper) {
        this.adminUserMapper = adminUserMapper;
        this.adminUserRoleMapper = adminUserRoleMapper;
    }

    @Override
    public List<AdminUser> getAdminUsers() {
        return adminUserMapper.selectAll()
                .stream()
                .filter(adminUser -> !"ADMIN".equals(adminUser.getType()))
                .peek(adminUser -> adminUser.setType(adminUserRoleMapper.selectNameByType(adminUser.getType())))
                .collect(Collectors.toList());
    }

    @Override
    public void delAdminUserById(String id) {
        adminUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addAdminUser(String name, String username, String type) {
        AdminUser adminUser = new AdminUser();
        adminUser.setId(UUID.randomUUID().toString().replace("-", ""));
        adminUser.setName(name);
        adminUser.setUsername(username);
        adminUser.setPassword("");
        adminUser.setType(type.toUpperCase());
        Date date = new Date();
        adminUser.setGmtCreate(date);
        adminUser.setGmtModified(date);
        adminUserMapper.insert(adminUser);
    }
}
