package org.mliuframework.spring.orm.dao;

import org.mliuframework.spring.orm.entity.Student;

import java.util.List;

/**
 * Created by Michael on 7/6/16.
 */
public interface StudentMapper {

    Student selectByPrimaryKey(Long id);

    List<Student> selectAll();

    List<Student> selectByProperties(Student student);

    int insert(Student student);

    int insertSelective(Student student);

    int updateByPrimaryKeySelective(Student student);

}
