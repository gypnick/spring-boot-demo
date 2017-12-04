package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.SysRole;
import site.site8.springboot.model.SysRoleExample;

import java.util.List;

@Mapper
@Component
public interface SysRoleMapper {
    @SelectProvider(type=SysRoleSqlProvider.class, method="countByExample")
    long countByExample(SysRoleExample example);

    @DeleteProvider(type=SysRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleExample example);

    @Delete({
        "delete from sysrole",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sysrole (id, role, ",
        "description, available)",
        "values (#{id,jdbcType=INTEGER}, #{role,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{available,jdbcType=CHAR})"
    })
    int insert(SysRole record);

    @InsertProvider(type=SysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysRole record);

    @SelectProvider(type=SysRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.CHAR)
    })
    List<SysRole> selectByExample(SysRoleExample example);

    @Select({
        "select",
        "id, role, description, available",
        "from sysrole",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="available", property="available", jdbcType=JdbcType.CHAR)
    })
    SysRole selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "sl.id, sl.role, sl.description, sl.available",
            "from sysrole sl",
            "LEFT JOIN sysuserrole s on(s.uid=#{uId,jdbcType=INTEGER})",
            "and s.roleId=sl.id"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="available", property="available", jdbcType=JdbcType.CHAR)
    })
    List<SysRole> getRoles(Integer uId);


    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sysrole",
        "set role = #{role,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "available = #{available,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRole record);
}