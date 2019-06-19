package top.itning.tmpp.tmppadmin.service;

import top.itning.tmpp.tmppadmin.pojo.Colleges;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/19 11:45
 */
public interface CollegesService {
    /**
     * 获取所有学院
     *
     * @return 学院集合
     */
    List<Colleges> getAllColleges();

    /**
     * 获取学院
     *
     * @param id 学院ID
     * @return 学院
     */
    Colleges getColleges(String id);

    /**
     * 保存学院
     *
     * @param name 学院名
     */
    void saveColleges(String name);

    /**
     * 删除学院
     *
     * @param id 学院ID
     */
    void delColleges(String id);

    /**
     * 修改学院
     *
     * @param id   学院ID
     * @param name 学院名
     */
    void upColleges(String id, String name);
}
