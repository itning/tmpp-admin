package top.itning.tmpp.tmppadmin.service.impl;

import org.springframework.stereotype.Service;
import top.itning.tmpp.tmppadmin.mapper.CollegesMapper;
import top.itning.tmpp.tmppadmin.pojo.Colleges;
import top.itning.tmpp.tmppadmin.service.CollegesService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author itning
 * @date 2019/6/19 11:48
 */
@Service
public class CollegesServiceImpl implements CollegesService {
    private final CollegesMapper collegesMapper;

    public CollegesServiceImpl(CollegesMapper collegesMapper) {
        this.collegesMapper = collegesMapper;
    }

    @Override
    public List<Colleges> getAllColleges() {
        return collegesMapper.selectAll();
    }

    @Override
    public Colleges getColleges(String id) {
        return collegesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveColleges(String name) {
        Colleges colleges = new Colleges();
        colleges.setId(UUID.randomUUID().toString().replace("-", ""));
        colleges.setName(name);
        Date date = new Date();
        colleges.setGmtModified(date);
        colleges.setGmtCreate(date);
        collegesMapper.insert(colleges);
    }

    @Override
    public void delColleges(String id) {
        collegesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void upColleges(String id, String name) {
        Colleges colleges = new Colleges();
        colleges.setId(id);
        colleges.setName(name);
        colleges.setGmtModified(new Date());
        collegesMapper.updateByPrimaryKeySelective(colleges);
    }
}
