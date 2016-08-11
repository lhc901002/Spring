package org.michaelliu.demo.spring.webmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.spring.webmvc.util.ConstantUtils;
import org.michaelliu.demo.spring.webmvc.util.PropertyUtils;
import org.michaelliu.demo.spring.webmvc.vo.RspVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michael on 7/11/16.
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {

    private static final Log log = LogFactory.getLog(MvcController.class);

    /**
     * http://localhost:8080/mvc/index
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
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
        RspVo message = new RspVo(0, "Hello Michael");
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

}
