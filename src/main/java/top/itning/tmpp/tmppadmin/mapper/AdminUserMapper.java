package top.itning.tmpp.tmppadmin.mapper;

import top.itning.tmpp.tmppadmin.pojo.AdminUser;

import java.util.List;

public interface AdminUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    AdminUser selectByUserName(String username);

    long countByType(String type);

    List<AdminUser> selectAll();
}