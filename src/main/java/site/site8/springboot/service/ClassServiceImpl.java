package site.site8.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.site8.springboot.dao.Class_Mapper;
import site.site8.springboot.model.Class_;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    Class_Mapper mapper;
    @Override
    public Class_ queryClassById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
