package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.SysUserRole;
import site.site8.springboot.model.SysUserRoleExample;

import java.util.List;
@Mapper
@Component
public interface SysUserRoleMapper {
    @SelectProvider(type=SysUserRoleSqlProvider.class, method="countByExample")
    long countByExample(SysUserRoleExample example);

    @DeleteProvider(type=SysUserRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserRoleExample example);

    @Delete({
        "delete from sysuserrole",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sysuserrole (id, uid, ",
        "roleId)",
        "values (#{id,jdbcType=INTEGER}, #{uid,jdbcType=INTEGER}, ",
        "#{roleid,jdbcType=INTEGER})"
    })
    int insert(SysUserRole record);

    @InsertProvider(type=SysUserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysUserRole record);

    @SelectProvider(type=SysUserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    List<SysUserRole> selectByExample(SysUserRoleExample example);

    @Select({
        "select",
        "id, uid, roleId",
        "from sysuserrole",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER)
    })
    SysUserRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysUserRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    @UpdateProvider(type=SysUserRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUserRole record, @Param("example") SysUserRoleExample example);

    @UpdateProvider(type=SysUserRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUserRole record);

    @Update({
        "update sysuserrole",
        "set uid = #{uid,jdbcType=INTEGER},",
          "roleId = #{roleid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysUserRole record);
}