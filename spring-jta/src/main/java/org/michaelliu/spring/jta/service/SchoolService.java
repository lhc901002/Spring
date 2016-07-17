package org.michaelliu.spring.jta.service;

import org.michaelliu.spring.jta.dao.StudentDao;
import org.michaelliu.spring.jta.entity.Teacher;
import org.michaelliu.spring.jta.dao.TeacherDao;
import org.michaelliu.spring.jta.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 7/5/16.
 */
@Service
public class SchoolService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    public void saveInfo(Student student, Teacher teacher) throws Exception {
        try {
            studentDao.insert(student);
            teacherDao.insert(teacher);
        } catch (Exception e) {
            throw e;
        }
    }

}
