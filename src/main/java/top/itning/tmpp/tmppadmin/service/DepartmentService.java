package top.itning.tmpp.tmppadmin.service;

import top.itning.tmpp.tmppadmin.pojo.Department;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/19 11:25
 */
public interface DepartmentService {
    /**
     * 获取所有授课部门
     *
     * @return 授课部门集合
     */
    List<Department> getAllDepartment();

    /**
     * 获取授课部门
     *
     * @param id 授课部门ID
     * @return 授课部门
     */
    Department getDepartment(String id);

    /**
     * 保存授课部门
     *
     * @param name 授课部门名称
     */
    void saveDepartment(String name);

    /**
     * 更新授课部门
     *
     * @param id      授课部门ID
     * @param newName 授课部门名称
     */
    void upDepartment(String id, String newName);

    /**
     * 删除授课部门
     *
     * @param id 授课部门ID
     */
    void delDepartment(String id);
}
