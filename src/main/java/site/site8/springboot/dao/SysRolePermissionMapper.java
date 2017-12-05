package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.SysRolePermission;
import site.site8.springboot.model.SysRolePermissionExample;

import java.util.List;
@Mapper
@Component
public interface SysRolePermissionMapper {
    @SelectProvider(type=SysRolePermissionSqlProvider.class, method="countByExample")
    long countByExample(SysRolePermissionExample example);

    @DeleteProvider(type=SysRolePermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRolePermissionExample example);

    @Delete({
        "delete from sysrolepermission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sysrolepermission (id, permissionId, ",
        "roleId)",
        "values (#{id,jdbcType=INTEGER}, #{permissionid,jdbcType=INTEGER}, ",
        "#{roleid,jdbcType=INTEGER})"
    })
    int insert(SysRolePermission record);

    @InsertProvider(type=SysRolePermissionSqlProvider.class, method="insertSelective")
    int insertSelective(SysRolePermission record);

    @SelectProvider(type=SysRolePermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permissionId", property="permissionid", jdbcType=JdbcType.INTEGER),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    @Select({
        "select",
        "id, permissionId, roleId",
        "from sysrolepermission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permissionId", property="permissionid", jdbcType=JdbcType.INTEGER),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    SysRolePermission selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysRolePermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    @UpdateProvider(type=SysRolePermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    @UpdateProvider(type=SysRolePermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRolePermission record);

    @Update({
        "update sysrolepermission",
        "set permissionId = #{permissionid,jdbcType=INTEGER},",
          "roleId = #{roleid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRolePermission record);
}