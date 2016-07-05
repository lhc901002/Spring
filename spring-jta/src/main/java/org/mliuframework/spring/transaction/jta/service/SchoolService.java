package org.mliuframework.spring.transaction.jta.service;

import org.mliuframework.spring.transaction.jta.dao.StudentDao;
import org.mliuframework.spring.transaction.jta.dao.TeacherDao;
import org.mliuframework.spring.transaction.jta.entity.Student;
import org.mliuframework.spring.transaction.jta.entity.Teacher;
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
