package org.mliuframework.spring.orm.ibatis.service;

import org.mliuframework.spring.orm.ibatis.bo.User;
import org.mliuframework.spring.orm.ibatis.mapper.UserMapper;
import org.mliuframework.spring.orm.ibatis.util.MyDateUtil;
import org.mliuframework.spring.orm.ibatis.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 类UserService
 *
 * @author liuhaocheng
 * @since 2016-06-13.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserVo findUserByPrimaryKey(Long id) throws IOException {
        User user = userMapper.selectByPrimaryKey(id);
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setName(user.getName());
        userVo.setCreateTime(MyDateUtil.getDateTimeByFormat(user.getCreateTime(), null));
        FileOutputStream fos = new FileOutputStream(new File("profile.txt"));
        fos.write(user.getProfile());
        return userVo;
    }

    public List<User> findUserListInUser(List<UserVo> userList) {
        List<User> users = userMapper.selectUserListInUser(userList);
        return users;
    }

    public void insertUser(UserVo userVo) throws IOException {
        String profileUrl = userVo.getProfileUrl();
        FileInputStream fis = new FileInputStream(new File(profileUrl));
        byte [] buffer = new byte[4096];
        fis.read(buffer);
        User user = new User();
        user.setId(userVo.getId());
        user.setName(userVo.getName());
        user.setCreateTime(MyDateUtil.getCurrentDateTime());
        user.setProfile(buffer);
        userMapper.insertSelective(user);
    }

}
