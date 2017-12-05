package site.site8.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.site8.springboot.dao.UserInfoMapper;
import site.site8.springboot.model.UserInfo;
import site.site8.springboot.model.UserInfoExample;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo queryUserInfoByUid(Integer uId) {
        return userInfoMapper.selectByPrimaryKey(uId);
    }

    @Override
    public UserInfo queryUserInfoByUserName(String userName) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if(null==userInfos||userInfos.size()==0) return null;
        return userInfos.get(0);
    }
}
