package org.michaelliu.spring.jta.atomikos.service;

import org.michaelliu.spring.beans.dto.Student;
import org.michaelliu.spring.beans.dto.Teacher;
import org.michaelliu.spring.jta.atomikos.dao.StudentDao;
import org.michaelliu.spring.jta.atomikos.dao.TeacherDao;
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
