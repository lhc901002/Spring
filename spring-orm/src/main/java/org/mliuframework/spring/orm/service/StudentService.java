package org.mliuframework.spring.orm.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.orm.dao.StudentHibernateDao;
import org.mliuframework.spring.orm.dao.StudentJDBCTemplateDao;
import org.mliuframework.spring.orm.dao.StudentJPADao;
import org.mliuframework.spring.orm.dao.StudentMapper;
import org.mliuframework.spring.orm.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 7/8/16.
 */
@Service
public class StudentService {

    private static final Log log = LogFactory.getLog(StudentService.class);

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentHibernateDao studentHibernateDao;

    @Autowired
    private StudentJDBCTemplateDao studentJDBCTemplateDao;

    @Autowired
    private StudentJPADao studentJPADao;

    public Student saveOrUpdateSelectiveUsingMybatis(Student student) throws Exception {
        log.info("saveOrUpdateSelective receives parameter: " + student);
        if (null == student) {
            throw new IllegalArgumentException("Student is null!");
        }
        Student studentEntity = null;
        try {
            int result;
            if (null == student.getId()) {
                result = studentMapper.insertSelective(student);
            } else {
                result = studentMapper.updateByPrimaryKeySelective(student);
            }
            if (result > 0) {
                studentEntity = student;
            } else {
                throw new IllegalStateException("Insertion fail to create/update new record in `tb_student`!");
            }
        } catch (Exception e) {
            log.error("saveOrUpdateSelective exception: " + e);
            throw e;
        }
        return studentEntity;
    }

    public void saveOrUpdateUsingJDBCTemplate(Student student) throws Exception {
        log.info("saveOrUpdate receives parameter: " + student);
        if (null == student) {
            throw new IllegalArgumentException("Student is null!");
        }
        try {
            int result;
            if (null == student.getId()) {
                result = studentJDBCTemplateDao.insert(student);
            } else {
                result = studentJDBCTemplateDao.updateByPrimaryKey(student);
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
