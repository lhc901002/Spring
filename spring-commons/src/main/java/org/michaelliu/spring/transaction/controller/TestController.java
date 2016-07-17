package org.michaelliu.spring.transaction.controller;

import org.michaelliu.spring.transaction.entity.Record;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michael on 6/30/16.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * http://localhost:8080/orm/test/go
     * @param record
     * @return
     */
    @RequestMapping(value = "/go", method = RequestMethod.POST)
    @ResponseBody
    public Integer go(@RequestBody Record record) {
        return 1;
    }

}
