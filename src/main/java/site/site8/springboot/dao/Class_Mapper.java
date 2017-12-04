package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.Class_;
import site.site8.springboot.model.Class_Example;

import java.util.List;

@Component
@Mapper
public interface Class_Mapper {
    @SelectProvider(type=Class_SqlProvider.class, method="countByExample")
    long countByExample(Class_Example example);

    @DeleteProvider(type=Class_SqlProvider.class, method="deleteByExample")
    int deleteByExample(Class_Example example);

    @Delete({
        "delete from class",
        "where c_id = #{cId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cId);

    @Insert({
        "insert into class (c_id, c_name, ",
        "teacher_id)",
        "values (#{cId,jdbcType=INTEGER}, #{cName,jdbcType=VARCHAR}, ",
        "#{teacherId,jdbcType=INTEGER})"
    })
    int insert(Class_ record);

    @InsertProvider(type=Class_SqlProvider.class, method="insertSelective")
    int insertSelective(Class_ record);

    @SelectProvider(type=Class_SqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER),
        @Result(property = "students",column="c_id",many = @Many(select = "site.site8.springboot.dao.StudentMapper.selectByClassId"))
    })
    List<Class_> selectByExample(Class_Example example);

    @Select({
        "select",
        "c_id, c_name, teacher_id",
        "from class",
        "where c_id = #{cId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="c_id", property="cId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="c_name", property="cName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER),
            @Result(property = "students",column="c_id",many = @Many(select = "site.site8.springboot.dao.StudentMapper.selectByClassId"))

    })
    Class_ selectByPrimaryKey(Integer cId);

    @UpdateProvider(type=Class_SqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Class_ record, @Param("example") Class_Example example);

    @UpdateProvider(type=Class_SqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Class_ record, @Param("example") Class_Example example);

    @UpdateProvider(type=Class_SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Class_ record);

    @Update({
        "update class",
        "set c_name = #{cName,jdbcType=VARCHAR},",
          "teacher_id = #{teacherId,jdbcType=INTEGER}",
        "where c_id = #{cId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Class_ record);
}