package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.Student;
import site.site8.springboot.model.StudentExample;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    @SelectProvider(type=StudentSqlProvider.class, method="countByExample")
    long countByExample(StudentExample example);

    @DeleteProvider(type=StudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentExample example);

    @Delete({
        "delete from student",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sId);

    @Insert({
        "insert into student (s_id, s_name, ",
        "class_id)",
        "values (#{sId,jdbcType=INTEGER}, #{sName,jdbcType=VARCHAR}, ",
        "#{classId,jdbcType=INTEGER})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER)
    })
    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "s_id, s_name, class_id",
        "from student",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER)
    })
    Student selectByPrimaryKey(Integer sId);
    @Select({
        "select",
        "s_id, s_name, class_id",
        "from student",
        "where class_id = #{classId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="s_id", property="sId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="s_name", property="sName", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER)
    })
    List<Student> selectByClassId(Integer classId);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set s_name = #{sName,jdbcType=VARCHAR},",
          "class_id = #{classId,jdbcType=INTEGER}",
        "where s_id = #{sId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Student record);
}