package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.UserInfo;
import site.site8.springboot.model.UserInfoExample;

import java.util.List;

@Mapper
@Component
public interface UserInfoMapper {
    @SelectProvider(type=UserInfoSqlProvider.class, method="countByExample")
    long countByExample(UserInfoExample example);

    @DeleteProvider(type=UserInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserInfoExample example);

    @Delete({
        "delete from userinfo",
        "where uid = #{uid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer uid);

    @Insert({
        "insert into userinfo (uid, username, ",
        "name, password, ",
        "salt)",
        "values (#{uid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{salt,jdbcType=VARCHAR})"
    })
    int insert(UserInfo record);

    @InsertProvider(type=UserInfoSqlProvider.class, method="insertSelective")
    int insertSelective(UserInfo record);

    @SelectProvider(type=UserInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR)
    })
    List<UserInfo> selectByExample(UserInfoExample example);

    @Select({
        "select",
        "uid, username, name, password, salt",
        "from userinfo",
        "where uid = #{uid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR),
            @Result(property = "roles",column = "uid",many = @Many(select = "site.site8.springboot.dao.SysRoleMapper.getRoles"))
    })
    UserInfo selectByPrimaryKey(Integer uid);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    @UpdateProvider(type=UserInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update userinfo",
        "set username = #{username,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR}",
        "where uid = #{uid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserInfo record);
}