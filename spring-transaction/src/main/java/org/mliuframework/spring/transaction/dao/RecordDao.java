package org.mliuframework.spring.transaction.dao;

import org.mliuframework.spring.transaction.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Michael on 6/30/16.
 */
@Repository
public class RecordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Record selectById(Long id) {
        String sql = "select id, r_name, balance from record where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object [] { id }, Record.class);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int insert(Record record) {
        String sql = "insert into record(r_name) values(?)";
        return jdbcTemplate.update(sql, record.getName());
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public int updateByIncreasingBalance(Long id) {
        String sql = "update record set balance = balance + 1 where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int updateByDecreasingBalance(Long id) {
        String sql = "update record set balance = balance - 1 where id = ?";
        return jdbcTemplate.update(sql, id);
    }

}
