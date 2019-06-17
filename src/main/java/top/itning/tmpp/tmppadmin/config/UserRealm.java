package top.itning.tmpp.tmppadmin.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.itning.tmpp.tmppadmin.pojo.AdminUser;
import top.itning.tmpp.tmppadmin.service.LoginService;

import java.util.Optional;

/**
 * @author itning
 * @date 2019/6/17 10:06
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    private final LoginService loginService;

    @Autowired
    public UserRealm(LoginService loginService) {
        this.loginService = loginService;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AdminUser adminUser = (AdminUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(adminUser.getType());
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        Optional<AdminUser> adminUserOptional = loginService.getAdminUserByUserName(usernamePasswordToken.getUsername());
        if (!adminUserOptional.isPresent()) {
            return null;
        }
        AdminUser adminUser = adminUserOptional.get();
        return new SimpleAuthenticationInfo(adminUser, adminUser.getPassword(), "userrealm");
    }
}
