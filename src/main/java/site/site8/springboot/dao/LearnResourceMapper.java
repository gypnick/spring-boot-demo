package site.site8.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import site.site8.springboot.model.LearnResource;
import site.site8.springboot.model.LearnResourceExample;

import java.util.List;

@Mapper
@Component
public interface LearnResourceMapper {
    @SelectProvider(type=LearnResourceSqlProvider.class, method="countByExample")
    long countByExample(LearnResourceExample example);

    @DeleteProvider(type=LearnResourceSqlProvider.class, method="deleteByExample")
    int deleteByExample(LearnResourceExample example);

    @Delete({
        "delete from learn_resource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into learn_resource (id, author, ",
        "title, url)",
        "values (#{id,jdbcType=BIGINT}, #{author,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR})"
    })
    int insert(LearnResource record);

    @InsertProvider(type=LearnResourceSqlProvider.class, method="insertSelective")
    int insertSelective(LearnResource record);

    @SelectProvider(type=LearnResourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR)
    })
    List<LearnResource> selectByExample(LearnResourceExample example);

    @Select({
        "select",
        "id, author, title, url",
        "from learn_resource",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR)
    })
    LearnResource selectByPrimaryKey(Long id);

    @UpdateProvider(type=LearnResourceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LearnResource record, @Param("example") LearnResourceExample example);

    @UpdateProvider(type=LearnResourceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LearnResource record, @Param("example") LearnResourceExample example);

    @UpdateProvider(type=LearnResourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LearnResource record);

    @Update({
        "update learn_resource",
        "set author = #{author,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LearnResource record);
}