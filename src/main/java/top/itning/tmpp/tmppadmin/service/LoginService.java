package top.itning.tmpp.tmppadmin.service;

import top.itning.tmpp.tmppadmin.pojo.AdminUser;

import java.util.Optional;

/**
 * @author itning
 * @date 2019/6/17 11:51
 */
public interface LoginService {
    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 如果没找到返回 {@link Optional#empty()}
     */
    Optional<AdminUser> getAdminUserByUserName(String username);

    /**
     * 检查是否有管理员账户
     *
     * @return 是返回真
     */
    boolean haveAdminAccount();

    /**
     * 初始化管理员账户
     *
     * @param username 用户名
     * @param password 密码
     */
    void initAdminAccount(String username, String password);
}
