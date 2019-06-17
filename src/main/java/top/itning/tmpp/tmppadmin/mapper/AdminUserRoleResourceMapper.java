package top.itning.tmpp.tmppadmin.mapper;

import top.itning.tmpp.tmppadmin.pojo.AdminUserRoleResource;
import top.itning.tmpp.tmppadmin.pojo.AdminUserRoleResourceKey;

import java.util.List;

public interface AdminUserRoleResourceMapper {
    int deleteByPrimaryKey(AdminUserRoleResourceKey key);

    int insert(AdminUserRoleResource record);

    int insertSelective(AdminUserRoleResource record);

    AdminUserRoleResource selectByPrimaryKey(AdminUserRoleResourceKey key);

    int updateByPrimaryKeySelective(AdminUserRoleResource record);

    int updateByPrimaryKey(AdminUserRoleResource record);

    List<AdminUserRoleResource> selectByResourceId(String resourceId);

    List<Integer> selectUserRoleByResourceId(String resourceId);
}