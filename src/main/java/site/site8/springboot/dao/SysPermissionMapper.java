package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.SysPermission;
import site.site8.springboot.model.SysPermissionExample;

import java.util.List;

@Mapper
@Component
public interface SysPermissionMapper {
    @SelectProvider(type=SysPermissionSqlProvider.class, method="countByExample")
    long countByExample(SysPermissionExample example);

    @DeleteProvider(type=SysPermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysPermissionExample example);

    @Delete({
        "delete from syspermission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into syspermission (id, name, ",
        "resourceType, url, ",
        "permission, parentId, ",
        "parentIds, available)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{resourcetype,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{permission,jdbcType=VARCHAR}, #{parentid,jdbcType=BIGINT}, ",
        "#{parentids,jdbcType=VARCHAR}, #{available,jdbcType=CHAR})"
    })
    int insert(SysPermission record);

    @InsertProvider(type=SysPermissionSqlProvider.class, method="insertSelective")
    int insertSelective(SysPermission record);

    @SelectProvider(type=SysPermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceType", property="resourcetype", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.BIGINT),
        @Result(column="parentIds", property="parentids", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.CHAR)
    })
    List<SysPermission> selectByExample(SysPermissionExample example);

    @Select({
        "select",
        "id, name, resourceType, url, permission, parentId, parentIds, available",
        "from syspermission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceType", property="resourcetype", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentId", property="parentid", jdbcType=JdbcType.BIGINT),
        @Result(column="parentIds", property="parentids", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.CHAR),
            @Result(column = "id",property = "sysRoles",many = @Many(select = "site.site8.springboot.dao.SysRoleMapper.getRolesBypermissionId"))
    })
    SysPermission selectByPrimaryKey(Integer id);


    @Select({
            "select",
            "sp.id, sp.name, sp.resourceType, sp.url, sp.permission, sp.parentId, sp.parentIds, sp.available",
            "from syspermission sp",
            "LEFT JOIN sysrolepermission  srp on (srp.roleId= #{rId,jdbcType=INTEGER})",
            "where sp.id = srp.permissionId"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="resourceType", property="resourcetype", jdbcType=JdbcType.VARCHAR),
            @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
            @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
            @Result(column="parentId", property="parentid", jdbcType=JdbcType.BIGINT),
            @Result(column="parentIds", property="parentids", jdbcType=JdbcType.VARCHAR),
            @Result(column="available", property="available", jdbcType=JdbcType.CHAR)
    })
    List<SysPermission> getPermissionByRoleId(Integer rId);

    @UpdateProvider(type=SysPermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    @UpdateProvider(type=SysPermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    @UpdateProvider(type=SysPermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysPermission record);

    @Update({
        "update syspermission",
        "set name = #{name,jdbcType=VARCHAR},",
          "resourceType = #{resourcetype,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "permission = #{permission,jdbcType=VARCHAR},",
          "parentId = #{parentid,jdbcType=BIGINT},",
          "parentIds = #{parentids,jdbcType=VARCHAR},",
          "available = #{available,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysPermission record);
}