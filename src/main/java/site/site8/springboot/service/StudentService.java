package site.site8.springboot.service;

import site.site8.springboot.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryStudentByClassId(Integer id);
}
