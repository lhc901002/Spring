package org.michaelliu.spring.orm.hibernate.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.orm.hibernate.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by michael on 2016/7/24.
 */
@Service
public class StudentService {

    private static final Log log = LogFactory.getLog(StudentService.class);

    @Autowired
    private StudentDao studentDao;

}
