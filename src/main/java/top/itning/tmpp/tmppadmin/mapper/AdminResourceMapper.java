package top.itning.tmpp.tmppadmin.mapper;

import top.itning.tmpp.tmppadmin.pojo.AdminResource;

import java.util.List;

public interface AdminResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminResource record);

    int insertSelective(AdminResource record);

    AdminResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminResource record);

    int updateByPrimaryKey(AdminResource record);

    List<AdminResource> selectAll();
}