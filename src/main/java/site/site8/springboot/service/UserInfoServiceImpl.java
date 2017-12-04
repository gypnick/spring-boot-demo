package site.site8.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.site8.springboot.dao.UserInfoMapper;
import site.site8.springboot.model.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo queryUserInfoByUid(Integer uId) {
        return userInfoMapper.selectByPrimaryKey(uId);
    }
}
