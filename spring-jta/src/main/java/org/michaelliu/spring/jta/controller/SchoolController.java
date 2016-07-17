package org.michaelliu.spring.jta.controller;

import org.michaelliu.spring.jta.entity.Teacher;
import org.michaelliu.spring.jta.entity.Student;
import org.michaelliu.spring.jta.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michael on 7/5/16.
 */
@Controller
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    /**
     * http://localhost:8080/jta/school/save
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public String save() {
        try {
            schoolService.saveInfo(new Student(111l, "Michael Liu", 25),
                    new Teacher(121l, "Lisa Yang", "Computer Science"));
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

}
