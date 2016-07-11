package org.mliuframework.spring.orm.ibatis.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.orm.ibatis.entity.Student;
import org.mliuframework.spring.orm.ibatis.service.StudentService;
import org.mliuframework.spring.orm.ibatis.util.ConstantUtils;
import org.mliuframework.spring.orm.ibatis.util.PropertyUtils;
import org.mliuframework.spring.orm.ibatis.vo.RspStudentVo;
import org.mliuframework.spring.orm.ibatis.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michael on 7/11/16.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private static final Log log = LogFactory.getLog(StudentController.class);

    @Autowired
    private StudentService studentService;

    /**
     * http://localhost:8080/orm/student/save
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RspStudentVo doSave(@RequestBody StudentVo studentVo) {
        log.info("doSave student receive: " + JSON.toJSONString(studentVo));
        RspStudentVo rspVo = new RspStudentVo();
        try {
            boolean failFlag = false;
            if (studentVo == null || !studentVo.containAllRequiredField()) {
                failFlag = true;
            } else {
                Student student = new Student.Builder().setId(studentVo.getId()).
                        setName(studentVo.getName()).setAge(studentVo.getAge()).build();
                Student studentEntity = studentService.saveOrUpdateSelective(student);
                if (null == studentEntity) {
                    failFlag = true;
                } else {
                    rspVo.setStatus(ConstantUtils.STATUS_SUCCESS);
                    rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                            ConstantUtils.STATUS_SUCCESS));
                    rspVo.setStudent(studentEntity);
                }
            }
            if (failFlag) {
                rspVo.setStatus(ConstantUtils.STATUS_FAIL);
                rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                        ConstantUtils.STATUS_FAIL));
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
