package site.site8.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.site8.springboot.dao.SysRoleMapper;
import site.site8.springboot.model.SysRole;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    SysRoleMapper roleMapper;
    @Override
    public List<SysRole> queryRoleByid() {
        return null;
    }

    @Override
    public SysRole selectByPrimaryKey(Integer rId) {
        return roleMapper.selectByPrimaryKey(rId);
    }
}
