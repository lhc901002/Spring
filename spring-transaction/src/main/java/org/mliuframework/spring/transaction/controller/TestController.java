package org.mliuframework.spring.transaction.controller;

import org.mliuframework.spring.transaction.entity.Record;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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