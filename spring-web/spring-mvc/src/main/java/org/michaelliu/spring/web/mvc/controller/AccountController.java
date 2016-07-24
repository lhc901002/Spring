package org.michaelliu.spring.web.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by michael on 2016/7/25.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private static final Log log = LogFactory.getLog(AccountController.class);

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }

}
