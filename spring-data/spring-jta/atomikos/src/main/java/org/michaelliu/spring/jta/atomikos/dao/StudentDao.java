package org.michaelliu.spring.jta.atomikos.dao;

import org.michaelliu.spring.beans.dto.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Michael on 7/5/16.
 */
@Repository
public class StudentDao {

    @Resource(name = "jdbcTemplateA")
    private JdbcTemplate jdbcTemplate;

    public void insert(Student student) {
        String sql = "insert into tb_student (id, s_name, s_age) values (?, ?, ?)";
        jdbcTemplate.update(sql, new Object [] {
                student.getId(), student.getName(), student.getAge() });
    }

}
