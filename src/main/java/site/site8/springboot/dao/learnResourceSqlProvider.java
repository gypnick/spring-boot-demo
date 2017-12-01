package site.site8.springboot.dao;

import org.apache.ibatis.jdbc.SQL;
import site.site8.springboot.model.learnResource;

public class learnResourceSqlProvider {

    public String insertSelective(learnResource record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("learn_resource");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getAuthor() != null) {
            sql.VALUES("author", "#{author,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(learnResource record) {
        SQL sql = new SQL();
        sql.UPDATE("learn_resource");
        
        if (record.getAuthor() != null) {
            sql.SET("author = #{author,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}