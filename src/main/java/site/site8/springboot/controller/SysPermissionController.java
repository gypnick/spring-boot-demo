package site.site8.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.site8.springboot.model.SysPermission;
import site.site8.springboot.service.SysPermissionService;

@RestController
@RequestMapping("/sysp")
public class SysPermissionController {
    @Autowired
    SysPermissionService service;

    @RequestMapping("/selectByPrimaryKey")
    public SysPermission selectByPrimaryKey(Integer id) {
        return service.selectByPrimaryKey(id);
    }
}
