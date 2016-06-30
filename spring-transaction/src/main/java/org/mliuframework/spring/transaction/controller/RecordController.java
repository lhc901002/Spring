package org.mliuframework.spring.transaction.controller;

import org.mliuframework.spring.transaction.entity.Record;
import org.mliuframework.spring.transaction.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michael on 6/30/16.
 */
@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     * http://localhost:8080/orm/record/increase?id=
     */
    @RequestMapping(value = "/increase", method = RequestMethod.GET)
    @ResponseBody
    public Integer increase(@RequestParam("id") Long id) {
        try {
            recordService.saveOrUpdateById(new Record(id, ""));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

}
