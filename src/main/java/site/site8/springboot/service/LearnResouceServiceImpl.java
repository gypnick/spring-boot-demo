package site.site8.springboot.service;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.site8.springboot.dao.LearnResourceMapper;
import site.site8.springboot.model.LearnResource;
import site.site8.springboot.model.LearnResourceExample;

import java.util.List;

@Service
public class LearnResouceServiceImpl implements LearnResouceService {
    @Autowired
    LearnResourceMapper learnResourceMapper;

    @Override
    public LearnResource queryLearnResouceById(Long learnResouce) {
        return learnResourceMapper.selectByPrimaryKey(learnResouce);
    }

    @Override
    public List<LearnResource> queryLearnResouce(int pageNum, int pageSize) {
        LearnResourceExample example = new LearnResourceExample();
         PageHelper.startPage(pageNum, pageSize);
        List<LearnResource> list = learnResourceMapper.selectByExample(example);
        return list;
    }
}
