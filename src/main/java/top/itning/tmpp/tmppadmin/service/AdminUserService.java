package top.itning.tmpp.tmppadmin.service;

import top.itning.tmpp.tmppadmin.pojo.AdminUser;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 17:56
 */
public interface AdminUserService {
    /**
     * 获取所有用户
     *
     * @return 用户集合
     */
    List<AdminUser> getAdminUsers();

    /**
     * 根据用户ID删除用户
     *
     * @param id 用户ID
     */
    void delAdminUserById(String id);

    /**
     * 添加用户
     *
     * @param name     昵称
     * @param username 用户名
     * @param type     角色
     */
    void addAdminUser(String name, String username, String type);
}
