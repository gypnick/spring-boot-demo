package site.site8.springboot.service;

import site.site8.springboot.model.SysPermission;

public interface SysPermissionService {
    SysPermission selectByPrimaryKey(Integer id);
}
