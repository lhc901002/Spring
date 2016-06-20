package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.bo.User;
import org.mliuframework.spring.orm.ibatis.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类UserMapper
 *
 * @author liuhaocheng
 * @since 2016-06-13.
 */
public interface UserMapper {
    User selectByPrimaryKey(@Param("id") Long id);
    List<User> selectAll();
    void insertUser(User user);
    void insertSelective(User user);

    List<User> selectUserListInUser(@Param("userList") List<UserVo> userList);
}
