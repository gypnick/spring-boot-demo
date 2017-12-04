package site.site8.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.site8.springboot.dao.StudentMapper;
import site.site8.springboot.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper mapper;
    @Override
    public List<Student> queryStudentByClassId(Integer id) {
        return mapper.selectByClassId(id);
    }
}
