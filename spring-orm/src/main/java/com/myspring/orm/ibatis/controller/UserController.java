package com.myspring.orm.ibatis.controller;

import com.alibaba.fastjson.JSON;
import com.myspring.orm.ibatis.service.UserService;
import com.myspring.orm.ibatis.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody String reqJson) throws IOException {
        UserVo userVo = JSON.parseObject(reqJson, UserVo.class);
        System.out.println(userVo);
        userService.insertUser(userVo);
        return "ok";
    }

}
