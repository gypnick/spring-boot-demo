package site.site8.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.site8.springboot.dao.SysPermissionMapper;
import site.site8.springboot.model.SysPermission;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    SysPermissionMapper mapper;
    @Override
    public SysPermission selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
