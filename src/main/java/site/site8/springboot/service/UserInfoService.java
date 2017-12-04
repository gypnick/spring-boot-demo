package site.site8.springboot.service;

import site.site8.springboot.model.UserInfo;

public interface UserInfoService {
    UserInfo queryUserInfoByUid(Integer uId);
}
