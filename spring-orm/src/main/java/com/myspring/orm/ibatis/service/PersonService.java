package com.myspring.orm.ibatis.service;

import com.myspring.orm.ibatis.bo.Country;
import com.myspring.orm.ibatis.bo.Person;
import com.myspring.orm.ibatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 2016/6/5.
 */
@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public void insertPerson(Person person) {
        personMapper.insertPerson(person);
    }

    public Country selectCountryByPersonId(Long personId) {
        return personMapper.selectCountryByPersonId(personId);
    }

}
