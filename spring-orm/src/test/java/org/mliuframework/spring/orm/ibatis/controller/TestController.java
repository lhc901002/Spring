package org.mliuframework.spring.orm.ibatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/go")
    @ResponseBody
    public String go(HttpServletRequest request) {
        String id = request.getHeader("id");
        String pid = request.getParameter("id");
        System.out.println(id);
        System.out.println(pid);
        return pid;
    }

}
