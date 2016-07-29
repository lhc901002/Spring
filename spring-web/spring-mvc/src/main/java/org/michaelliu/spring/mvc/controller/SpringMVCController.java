package org.michaelliu.spring.mvc.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.mvc.util.ConstantUtils;
import org.michaelliu.spring.mvc.util.PropertyUtils;
import org.michaelliu.spring.mvc.vo.RspStudentVo;
import org.michaelliu.spring.mvc.vo.RspVo;
import org.michaelliu.spring.mvc.vo.StudentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michael on 7/11/16.
 */
@Controller
@RequestMapping("/mvc")
public class SpringMVCController {

    private static final Log log = LogFactory.getLog(SpringMVCController.class);

    /**
     * http://localhost:8080/mvc/index
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }

    /**
     * http://localhost:8080/mvc/home
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("/home");
        RspVo message = new RspVo();
        message.setStatus(0);
        message.setStatusInfo("Hello Michael");
        mav.addObject("message", message);
        return mav;
    }

    /**
     * http://localhost:8080/mvc/message
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public RspVo getMessage() {
        return new RspVo(123, "hello world");
    }

    /**
     * http://localhost:8080/mvc/error
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    @ResponseBody
    public RspVo errorMessage() {
        return new RspVo(ConstantUtils.STATUS_EXCEPTION,
                PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                ConstantUtils.STATUS_EXCEPTION));
    }

    /**
     * http://localhost:8080/mvc/student/save
     */
    @RequestMapping(value = "/student/save", method = RequestMethod.POST)
    @ResponseBody
    public RspStudentVo saveStudent(@RequestBody StudentVo studentVo) {
        log.info("saveStudent receives: " + JSON.toJSONString(studentVo));
        // do something ...
        RspStudentVo rspVo = new RspStudentVo(ConstantUtils.STATUS_SUCCESS,
                PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX + ConstantUtils.STATUS_SUCCESS),
                studentVo);
        log.info("saveStudent returns: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

    /**
     * http://localhost:8080/mvc/student/find?id=ID
     */
    @RequestMapping(value = "/student/find", method = RequestMethod.GET)
    @ResponseBody
    public RspStudentVo findById(@RequestParam Long id) {
        log.info("findById receives: " + id);
        // do something ...
        RspStudentVo rspVo = new RspStudentVo(ConstantUtils.STATUS_SUCCESS,
                PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX + ConstantUtils.STATUS_SUCCESS),
                new StudentVo.Builder().setId(id).build());
        log.info("findById returns: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

}
