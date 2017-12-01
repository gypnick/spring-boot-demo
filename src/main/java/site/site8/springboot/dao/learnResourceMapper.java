package site.site8.springboot.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import site.site8.springboot.model.learnResource;

public interface learnResourceMapper {
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
    int insert(learnResource record);

    @InsertProvider(type=learnResourceSqlProvider.class, method="insertSelective")
    int insertSelective(learnResource record);

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
    learnResource selectByPrimaryKey(Long id);

    @UpdateProvider(type=learnResourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(learnResource record);

    @Update({
        "update learn_resource",
        "set author = #{author,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(learnResource record);
}