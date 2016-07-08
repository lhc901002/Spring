package org.mliuframework.spring.orm.ibatis.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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


}
