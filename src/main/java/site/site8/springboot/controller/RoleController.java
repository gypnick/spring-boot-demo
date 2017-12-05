package site.site8.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.site8.springboot.model.SysRole;
import site.site8.springboot.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService service;
    @RequestMapping("/selectByPrimaryKey")
    public SysRole selectByPrimaryKey(Integer rId) {
     return    service.selectByPrimaryKey(rId);
    }
}
