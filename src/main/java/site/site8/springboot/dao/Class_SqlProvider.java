package site.site8.springboot.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import site.site8.springboot.model.Class_;
import site.site8.springboot.model.Class_Example.Criteria;
import site.site8.springboot.model.Class_Example.Criterion;
import site.site8.springboot.model.Class_Example;

public class Class_SqlProvider {

    public String countByExample(Class_Example example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("class");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(Class_Example example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("class");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Class_ record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("class");
        
        if (record.getcId() != null) {
            sql.VALUES("c_id", "#{cId,jdbcType=INTEGER}");
        }
        
        if (record.getcName() != null) {
            sql.VALUES("c_name", "#{cName,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherId() != null) {
            sql.VALUES("teacher_id", "#{teacherId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(Class_Example example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("c_id");
        } else {
            sql.SELECT("c_id");
        }
        sql.SELECT("c_name");
        sql.SELECT("teacher_id");
        sql.FROM("class");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Class_ record = (Class_) parameter.get("record");
        Class_Example example = (Class_Example) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("class");
        
        if (record.getcId() != null) {
            sql.SET("c_id = #{record.cId,jdbcType=INTEGER}");
        }
        
        if (record.getcName() != null) {
            sql.SET("c_name = #{record.cName,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("class");
        
        sql.SET("c_id = #{record.cId,jdbcType=INTEGER}");
        sql.SET("c_name = #{record.cName,jdbcType=VARCHAR}");
        sql.SET("teacher_id = #{record.teacherId,jdbcType=INTEGER}");
        
        Class_Example example = (Class_Example) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Class_ record) {
        SQL sql = new SQL();
        sql.UPDATE("class");
        
        if (record.getcName() != null) {
            sql.SET("c_name = #{cName,jdbcType=VARCHAR}");
        }
        
        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{teacherId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("c_id = #{cId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, Class_Example example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}