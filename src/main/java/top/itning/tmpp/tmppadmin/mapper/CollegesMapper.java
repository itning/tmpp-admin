package top.itning.tmpp.tmppadmin.mapper;

import top.itning.tmpp.tmppadmin.pojo.Colleges;

public interface CollegesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Colleges record);

    int insertSelective(Colleges record);

    Colleges selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Colleges record);

    int updateByPrimaryKey(Colleges record);
}