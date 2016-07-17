package org.michaelliu.spring.jta.dao;

import org.michaelliu.spring.jta.entity.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Michael on 7/5/16.
 */
@Repository
public class TeacherDao {

    @Resource(name = "jdbcTemplateB")
    private JdbcTemplate jdbcTemplate;

    public void insert(Teacher teacher) {
        String sql = "insert into tb_teacher (id, t_name, t_department) values (?, ?, ?)";
        jdbcTemplate.update(sql, new Object [] {
                teacher.getId(), teacher.getName(), teacher.getDepartment() });
    }

}
