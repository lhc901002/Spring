package org.michaelliu.spring.transaction.dao;

import org.michaelliu.spring.transaction.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Michael on 6/30/16.
 */
@Repository
public class RecordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Record selectById(Long id) {
        String sql = "select id, r_name, balance from record where id = ?";
        final Record record = new Record();
        jdbcTemplate.query(sql, new Object[] {id}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                record.setBalance(rs.getInt("balance"));
            }
        });
        return record;
    }

    public int insert(Record record) {
        String sql = "insert into record(r_name) values(?)";
        return jdbcTemplate.update(sql, record.getName());
    }

    public int updateByIncreaseBalance(Long id, Integer balance) {
        String sql = "update record set balance = ? where id = ?";
        return jdbcTemplate.update(sql, new Object [] { balance, id });
    }

    public int updateByAutoIncrease(Long id) {
        String sql = "update record set balance = balance + 1 where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateByAutoDecrease(Long id) {
        String sql = "update record set balance = balance - 1 where id = ? and balance > 0";
        return jdbcTemplate.update(sql, id);
    }

}
