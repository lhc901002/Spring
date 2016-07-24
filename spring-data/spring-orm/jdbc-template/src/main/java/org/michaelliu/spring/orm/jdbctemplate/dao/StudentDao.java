package org.michaelliu.spring.orm.jdbctemplate.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Michael on 7/12/16.
 */
@Repository
public class StudentDao {

    private static final Log log = LogFactory.getLog(StudentDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Student student) {
        log.info("insert receives parameter: " + student);
        String sql = "insert into tb_student (s_name, s_age) values (?, ?)";
        return jdbcTemplate.update(sql, new Object [] { student.getName(),
                student.getAge() });
    }

    public int updateByPrimaryKey(Student student) {
        log.info("updateByPrimaryKey receives parameter: " + student);
        String sql = "update tb_student set s_name = ?, s_age = ? where id = ?";
        return jdbcTemplate.update(sql, new Object [] { student.getName(),
                student.getAge(), student.getId() });
    }

}
