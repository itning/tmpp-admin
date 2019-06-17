package top.itning.tmpp.tmppadmin.mapper;

import top.itning.tmpp.tmppadmin.pojo.AdminUserRole;

import java.util.List;

public interface AdminUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUserRole record);

    int insertSelective(AdminUserRole record);

    AdminUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUserRole record);

    int updateByPrimaryKey(AdminUserRole record);

    List<AdminUserRole> selectByResourceId(String resourceId);

    List<AdminUserRole> selectAll();

    String selectNameByType(String type);
}