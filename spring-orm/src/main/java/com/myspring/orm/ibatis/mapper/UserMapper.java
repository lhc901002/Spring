package com.myspring.orm.ibatis.mapper;

import com.myspring.orm.ibatis.bo.User;

import java.util.List;

/**
 * 类UserMapper
 *
 * @author liuhaocheng
 * @since 2016-06-13.
 */
public interface UserMapper {
    User selectByPrimaryKey(Long id);
    List<User> selectAll();
    void insertUser(User user);
    void insertSelective(User user);
}
