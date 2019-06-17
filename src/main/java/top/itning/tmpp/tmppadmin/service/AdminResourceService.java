package top.itning.tmpp.tmppadmin.service;

import top.itning.tmpp.tmppadmin.pojo.AdminResource;
import top.itning.tmpp.tmppadmin.pojo.AdminResourceWithRoles;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 14:58
 */
public interface AdminResourceService {
    /**
     * 获取所有资源
     *
     * @return 资源集合
     */
    List<AdminResourceWithRoles> getAllAdminResources();

    /**
     * 根据ID获取资源
     *
     * @param id ID
     * @return 资源
     */
    AdminResource getAdminResourceById(String id);

    /**
     * 保存资源
     *
     * @param url    资源
     * @param method 方法
     * @param roles  角色
     */
    void saveAdminResource(String url, String method, int[] roles);

    /**
     * 删除资源
     *
     * @param id 资源ID
     */
    void delAdminResource(String id);

    /**
     * 修改资源
     *
     * @param id        资源ID
     * @param newUrl    新资源
     * @param newMethod 新方法
     * @param roles     角色
     */
    void upAdminResource(String id, String newUrl, String newMethod, int[] roles);
}
