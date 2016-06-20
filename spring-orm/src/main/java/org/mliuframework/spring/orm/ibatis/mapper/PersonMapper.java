package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.bo.Country;
import org.mliuframework.spring.orm.ibatis.bo.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Michael on 2016/6/5.
 */
public interface PersonMapper {

    void insertPerson(Person person);

    Country selectCountryByPersonId(Long personId);

    List<Person> selectAll();

    List<Person> selectAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

}
