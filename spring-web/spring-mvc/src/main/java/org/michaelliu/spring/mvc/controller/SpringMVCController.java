package org.michaelliu.spring.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.mvc.vo.MessageVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michael on 7/11/16.
 */
@Controller
@RequestMapping("/mvc")
public class SpringMVCController {

    private static final Log log = LogFactory.getLog(SpringMVCController.class);

    /**
     * http://localhost:8080/mvc/home
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("/home");
        MessageVo message = new MessageVo();
        message.setStatus(0);
        message.setStatusInfo("Hello Michael");
        mav.addObject("message", message);
        return mav;
    }

}
