package org.mliuframework.spring.orm.ibatis.service;

import org.mliuframework.spring.orm.ibatis.bo.Country;
import org.mliuframework.spring.orm.ibatis.bo.Person;
import org.mliuframework.spring.orm.ibatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Person> selectAllPersonByLimit(int offset, int limit) {
        return personMapper.selectAllByLimit(offset, limit);
    }

}