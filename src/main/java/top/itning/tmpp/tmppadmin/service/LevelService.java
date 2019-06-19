package top.itning.tmpp.tmppadmin.service;

import top.itning.tmpp.tmppadmin.pojo.Level;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/19 11:00
 */
public interface LevelService {
    /**
     * 获取所有层次
     *
     * @return 层次集合
     */
    List<Level> getAllLevel();

    /**
     * 保存层次
     *
     * @param educationalLevel 层次
     */
    void saveLevel(String educationalLevel);

    /**
     * 删除层次
     *
     * @param id 层次ID
     */
    void delLevel(String id);

    /**
     * 修改层次
     *
     * @param id                  层次ID
     * @param newEducationalLevel 新层次
     */
    void upLevel(String id, String newEducationalLevel);

    /**
     * 获取层次
     *
     * @param id 层次ID
     * @return 层次
     */
    Level getLevel(String id);
}
