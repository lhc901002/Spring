package org.michaelliu.spring.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Michael on 7/11/16.
 */
@Controller
@RequestMapping("/filter")
public class FilterController {

    private static final Log log = LogFactory.getLog(FilterController.class);

    /**
     * http://localhost:8080/filter/index
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "filter/index";
    }


}
