package top.itning.tmpp.tmppadmin.service;

import top.itning.tmpp.tmppadmin.pojo.AdminUserRole;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 16:55
 */
public interface AdminUserRoleService {
    /**
     * 根据资源ID获取该资源下可访问的用户角色信息
     *
     * @param resourceId 资源ID
     * @return 用户角色信息集合
     */
    List<AdminUserRole> getAdminUserRoleByResourceId(String resourceId);

    /**
     * 获取所有用户角色信息
     *
     * @return 用户角色信息集合
     */
    List<AdminUserRole> getAdminUserRoles();
}
