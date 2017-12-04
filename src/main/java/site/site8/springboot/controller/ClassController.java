package site.site8.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.site8.springboot.model.Class_;
import site.site8.springboot.service.ClassService;

@RestController
public class ClassController {
    @Autowired
    ClassService classService;


    @RequestMapping("/queryClassById")
    public Class_ queryClassById(Integer id) {
        return classService.queryClassById(id);
    }
}
