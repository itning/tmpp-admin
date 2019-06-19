package top.itning.tmpp.tmppadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.itning.tmpp.tmppadmin.mapper.DepartmentMapper;
import top.itning.tmpp.tmppadmin.pojo.Department;
import top.itning.tmpp.tmppadmin.service.DepartmentService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author itning
 * @date 2019/6/19 11:28
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.selectAll();
    }

    @Override
    public Department getDepartment(String id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveDepartment(String name) {
        Department department = new Department();
        department.setId(UUID.randomUUID().toString().replace("-", ""));
        department.setName(name);
        Date date = new Date();
        department.setGmtModified(date);
        department.setGmtCreate(date);
        departmentMapper.insert(department);
    }

    @Override
    public void upDepartment(String id, String newName) {
        Department department = new Department();
        department.setId(id);
        department.setName(newName);
        department.setGmtModified(new Date());
        departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public void delDepartment(String id) {
        departmentMapper.deleteByPrimaryKey(id);
    }
}
