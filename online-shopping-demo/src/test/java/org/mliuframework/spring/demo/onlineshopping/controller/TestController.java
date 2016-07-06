package org.mliuframework.spring.demo.onlineshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    private static final Log log = LogFactory.getLog(TestController.class);

    /**
     * http://localhost:8080/onlineshopping/test/go
     * @return
     */
    @RequestMapping(value = "/go", method = RequestMethod.GET)
    @ResponseBody
    public String go() {
        return "ok";
    }

}
