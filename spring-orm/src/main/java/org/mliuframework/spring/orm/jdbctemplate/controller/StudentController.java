package org.mliuframework.spring.orm.jdbctemplate.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.orm.commons.entity.Student;
import org.mliuframework.spring.orm.commons.util.ConstantUtils;
import org.mliuframework.spring.orm.commons.util.PropertyUtils;
import org.mliuframework.spring.orm.commons.vo.RspStudentVo;
import org.mliuframework.spring.orm.commons.vo.StudentVo;
import org.mliuframework.spring.orm.jdbctemplate.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Michael on 7/11/16.
 */
@Controller("studentJDBCTemplateController")
@RequestMapping("/jdbctemplate/student")
public class StudentController {

    private static final Log log = LogFactory.getLog(StudentController.class);

    @Resource(name = "studentJDBCTemplateService")
    private StudentService studentService;

    /**
     * http://localhost:8080/orm/jdbctemplate/student/save
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RspStudentVo doSave(@RequestBody StudentVo studentVo) {
        log.info("doSave student receive: " + JSON.toJSONString(studentVo));
        RspStudentVo rspVo = new RspStudentVo();
        try {
            if (studentVo == null || !studentVo.containAllRequiredField()) {
                rspVo.setStatus(ConstantUtils.STATUS_FAIL);
                rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                        ConstantUtils.STATUS_FAIL));
            } else {
                Student student = new Student.Builder().setId(studentVo.getId()).
                        setName(studentVo.getName()).setAge(studentVo.getAge()).build();
                studentService.saveOrUpdate(student);
                rspVo.setStatus(ConstantUtils.STATUS_SUCCESS);
                rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                        ConstantUtils.STATUS_SUCCESS));
            }
        } catch (Exception e) {
            log.error("doSave student throws exception: " + e);
            rspVo.setStatus(ConstantUtils.STATUS_EXCEPTION);
            rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                    ConstantUtils.STATUS_EXCEPTION) + ": " + e);
        }
        log.info("doSave customer return: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

}
