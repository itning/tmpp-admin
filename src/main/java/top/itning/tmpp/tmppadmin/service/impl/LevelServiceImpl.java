package top.itning.tmpp.tmppadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.itning.tmpp.tmppadmin.mapper.LevelMapper;
import top.itning.tmpp.tmppadmin.pojo.Level;
import top.itning.tmpp.tmppadmin.service.LevelService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author itning
 * @date 2019/6/19 11:01
 */
@Service
public class LevelServiceImpl implements LevelService {
    private final LevelMapper levelMapper;

    @Autowired
    public LevelServiceImpl(LevelMapper levelMapper) {
        this.levelMapper = levelMapper;
    }

    @Override
    public List<Level> getAllLevel() {
        return levelMapper.selectAll();
    }

    @Override
    public void saveLevel(String educationalLevel) {
        Level level = new Level();
        level.setId(UUID.randomUUID().toString().replace("-", ""));
        level.setEducationalLevel(educationalLevel);
        Date date = new Date();
        level.setGmtModified(date);
        level.setGmtCreate(date);
        levelMapper.insert(level);
    }

    @Override
    public void delLevel(String id) {
        levelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void upLevel(String id, String newEducationalLevel) {
        Level level = new Level();
        level.setId(id);
        level.setEducationalLevel(newEducationalLevel);
        level.setGmtModified(new Date());
        levelMapper.updateByPrimaryKeySelective(level);
    }

    @Override
    public Level getLevel(String id) {
        return levelMapper.selectByPrimaryKey(id);
    }
}
