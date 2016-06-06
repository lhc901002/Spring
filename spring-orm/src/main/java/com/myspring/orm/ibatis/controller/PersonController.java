package com.myspring.orm.ibatis.controller;

import com.alibaba.fastjson.JSON;
import com.myspring.orm.ibatis.bo.Country;
import com.myspring.orm.ibatis.bo.Person;
import com.myspring.orm.ibatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Michael on 2016/6/5.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addPerson(@RequestBody String reqJson) {
        Person person = JSON.parseObject(reqJson, Person.class);
        System.out.println(person);
        personService.insertPerson(person);
        return "ok";
    }

    @RequestMapping(value = "/get/country/personId", method = RequestMethod.GET)
    @ResponseBody
    public String getCountryByPersonId(@RequestParam Long id) {
        System.out.println(id);
        Country country = personService.selectCountryByPersonId(id);
        System.out.println(country);
        return JSON.toJSONString(country);
    }

}
