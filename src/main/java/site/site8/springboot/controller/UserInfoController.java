package site.site8.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.site8.springboot.model.UserInfo;
import site.site8.springboot.service.UserInfoService;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService service;

    @RequestMapping("/queryUserInfoByUid")
    public UserInfo queryUserInfoByUid(Integer id) {
        System.out.println("====uId======="+id);
        return service.queryUserInfoByUid(id);
    }
}
