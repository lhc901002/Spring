package org.mliuframework.spring.orm.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.orm.entity.Student;
import org.mliuframework.spring.orm.service.StudentService;
import org.mliuframework.spring.orm.util.ConstantUtils;
import org.mliuframework.spring.orm.util.PropertyUtils;
import org.mliuframework.spring.orm.vo.RspStudentListVo;
import org.mliuframework.spring.orm.vo.RspStudentVo;
import org.mliuframework.spring.orm.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
     * http://localhost:8080/orm/student/mybatis/save
     */
    @RequestMapping(value = "/mybatis/save", method = RequestMethod.POST)
    @ResponseBody
    public RspStudentVo doSaveByMybatis(@RequestBody StudentVo studentVo) {
        log.info("doSave student receives: " + JSON.toJSONString(studentVo));
        RspStudentVo rspVo = new RspStudentVo();
        try {
            boolean failFlag = false;
            if (studentVo == null || !studentVo.containAllRequiredField()) {
                failFlag = true;
            } else {
                Student student = new Student.Builder().setId(studentVo.getId()).
                        setName(studentVo.getName()).setAge(studentVo.getAge()).build();
                Student studentEntity = studentService.saveOrUpdateSelectiveUsingMybatis(student);
                if (null == studentEntity) {
                    failFlag = true;
                } else {
                    studentVo.setId(studentEntity.getId());
                    rspVo.setStatus(ConstantUtils.STATUS_SUCCESS);
                    rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                            ConstantUtils.STATUS_SUCCESS));
                    rspVo.setStudent(studentVo);
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
        log.info("doSave customer returns: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

    /**
     * http://localhost:8080/orm/student/jdbctemplate/save
     */
    @RequestMapping(value = "/jdbctemplate/save", method = RequestMethod.POST)
    @ResponseBody
    public RspStudentVo doSaveByJDBCTemplate(@RequestBody StudentVo studentVo) {
        log.info("doSave student receives: " + JSON.toJSONString(studentVo));
        RspStudentVo rspVo = new RspStudentVo();
        try {
            if (studentVo == null || !studentVo.containAllRequiredField()) {
                rspVo.setStatus(ConstantUtils.STATUS_FAIL);
                rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                        ConstantUtils.STATUS_FAIL));
            } else {
                Student student = new Student.Builder().setId(studentVo.getId()).
                        setName(studentVo.getName()).setAge(studentVo.getAge()).build();
                studentService.saveOrUpdateUsingJDBCTemplate(student);
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
        log.info("doSave customer returns: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

    /**
     * http://localhost:8080/orm/student/findbyname
     */
    @RequestMapping(value = "/findbyname", method = RequestMethod.POST)
    @ResponseBody
    public RspStudentListVo findByName(@RequestBody StudentVo studentVo) {
        log.info("findByName receives: " + JSON.toJSONString(studentVo));
        RspStudentListVo rspVo = new RspStudentListVo();
        try {
            if (studentVo == null || !studentVo.containAllRequiredField()) {
                rspVo.setStatus(ConstantUtils.STATUS_FAIL);
                rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                        ConstantUtils.STATUS_FAIL));
            } else {
                List<StudentVo> studentList = studentService.findByName(studentVo.getName());
                rspVo.setStatus(ConstantUtils.STATUS_SUCCESS);
                rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                        ConstantUtils.STATUS_SUCCESS));
                rspVo.setStudentList(studentList);
            }
        } catch (Exception e) {
            log.error("findByName throws exception: " + e);
            rspVo.setStatus(ConstantUtils.STATUS_EXCEPTION);
            rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                    ConstantUtils.STATUS_EXCEPTION) + ": " + e);
        }
        log.info("findByName returns: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

}
