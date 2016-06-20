package org.mliuframework.spring.orm.ibatis.controller;

import com.alibaba.fastjson.JSON;
import org.mliuframework.spring.orm.ibatis.bo.User;
import org.mliuframework.spring.orm.ibatis.service.UserService;
import org.mliuframework.spring.orm.ibatis.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 类UserController
 *
 * @author liuhaocheng
 * @since 2016-06-13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String findUserByPrimaryKey(@RequestParam Long userId) throws IOException {
        System.out.println(userId);
        UserVo userVo = userService.findUserByPrimaryKey(userId);
        System.out.println(userVo);
        return JSON.toJSONString(userVo);
    }

    @RequestMapping(value = "/findUserListInUser", method = RequestMethod.GET)
    @ResponseBody
    public String findUserListInUser() {
        UserVo userVo = new UserVo();
        userVo.setId(10000L);
        UserVo userVo1 = new UserVo();
        userVo1.setId(10001L);
        List<UserVo> userList = new LinkedList<UserVo>();
        userList.add(userVo);
        userList.add(userVo1);
        List<User> users = userService.findUserListInUser(userList);
        System.out.println(users);
        return JSON.toJSONString(userVo);
    }



    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody String reqJson) throws IOException {
        UserVo userVo = JSON.parseObject(reqJson, UserVo.class);
        System.out.println(userVo);
        userService.insertUser(userVo);
        return "ok";
    }

}
