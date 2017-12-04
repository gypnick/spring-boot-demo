package site.site8.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.site8.springboot.model.Student;
import site.site8.springboot.service.StudentService;

import java.util.List;

@RestController
public class StudentController  {
    @Autowired
    StudentService studentService;
    @RequestMapping("/queryStudentByClassId")
    public List<Student> queryStudentByClassId(Integer id) {
       return studentService.queryStudentByClassId(id);
    }
}
