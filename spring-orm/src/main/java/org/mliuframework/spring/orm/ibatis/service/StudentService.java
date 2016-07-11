package org.mliuframework.spring.orm.ibatis.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.orm.ibatis.entity.Student;
import org.mliuframework.spring.orm.ibatis.mapper.StudentMapper;
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

    public Student saveOrUpdateSelective(Student student) throws Exception {
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

}
