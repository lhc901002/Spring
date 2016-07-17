package org.michaelliu.spring.transaction.controller;

import org.michaelliu.spring.transaction.service.RecordService;
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
            synchronized (this) {
                return recordService.updateByIncrease(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * http://localhost:8080/orm/record/autoincrease?id=
     */
    @RequestMapping(value = "/autoincrease", method = RequestMethod.GET)
    @ResponseBody
    public Integer autoincrease(@RequestParam("id") Long id) {
        try {
            return recordService.updateByAutoIncrease(id);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * http://localhost:8080/orm/record/autodecrease?id=
     */
    @RequestMapping(value = "/autodecrease", method = RequestMethod.GET)
    @ResponseBody
    public Integer autodecrease(@RequestParam("id") Long id) {
        try {
            return recordService.updateByAutoDecrease(id);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
