package org.michaelliu.spring.orm.jdbctemplate.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Student;
import org.michaelliu.spring.orm.jdbctemplate.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 7/8/16.
 */
@Service
public class StudentService {

    private static final Log log = LogFactory.getLog(StudentService.class);

    @Autowired
    private StudentDao studentDao;

    public void saveOrUpdate(Student student) throws Exception {
        log.info("saveOrUpdate receives parameter: " + student);
        if (null == student) {
            throw new IllegalArgumentException("Student is null!");
        }
        try {
            int result;
            if (null == student.getId()) {
                result = studentDao.insert(student);
            } else {
                result = studentDao.updateByPrimaryKey(student);
            }
            if (result <= 0) {
                throw new IllegalStateException("Insertion fail to create/update new record in `tb_student`!");
            }
        } catch (Exception e) {
            log.error("saveOrUpdateSelective exception: " + e);
            throw e;
        }
    }

}
