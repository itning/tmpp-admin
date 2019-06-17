package top.itning.tmpp.tmppadmin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.itning.tmpp.tmppadmin.mapper.AdminUserMapper;
import top.itning.tmpp.tmppadmin.pojo.AdminUser;
import top.itning.tmpp.tmppadmin.service.LoginService;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * @author itning
 * @date 2019/6/17 11:54
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final AdminUserMapper adminUserMapper;

    @Autowired
    public LoginServiceImpl(AdminUserMapper adminUserMapper) {
        this.adminUserMapper = adminUserMapper;
    }

    @Override
    public Optional<AdminUser> getAdminUserByUserName(String username) {
        if (StringUtils.isBlank(username)) {
            //TODO 抛异常
        }
        return Optional.ofNullable(adminUserMapper.selectByUserName(username));
    }

    @Override
    public boolean haveAdminAccount() {
        return adminUserMapper.countByType("ADMIN") != 0;
    }

    @Override
    public void initAdminAccount(String username, String password) {
        AdminUser adminUser = new AdminUser();
        adminUser.setId(UUID.randomUUID().toString().replace("-", ""));
        adminUser.setName("管理员");
        adminUser.setUsername(username);
        adminUser.setPassword(password);
        adminUser.setType("ADMIN");
        Date date = new Date();
        adminUser.setGmtCreate(date);
        adminUser.setGmtModified(date);
        adminUserMapper.insert(adminUser);
    }
}
