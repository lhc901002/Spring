package org.michaelliu.spring.orm.mybatis.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Student;
import org.michaelliu.spring.beans.vo.StudentVo;
import org.michaelliu.spring.orm.mybatis.dao.StudentDao;
import org.michaelliu.spring.orm.mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 7/8/16.
 */
@Service
public class StudentService {

    private static final Log log = LogFactory.getLog(StudentService.class);

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentDao studentDao;

    public Student saveOrUpdateSelective(Student student) throws Exception {
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
                student.setUpdateTime(new Date());
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

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public StudentVo findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Student's id is empty!");
        }
        return studentMapper.selectByPrimaryKey(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<StudentVo> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Student's name is empty!");
        }
        return studentMapper.selectByName(name);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public PageList findPageList(Integer page, Integer pageSize) {
        PageBounds pageBounds = new PageBounds(page, pageSize);
        List studentList = studentDao.findPageList(pageBounds);
        PageList studentPageList = (PageList)studentList;
        return studentPageList;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public PageList findPageListByName(String name, Integer page, Integer pageSize) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Student's name is empty!");
        }
        PageBounds pageBounds = new PageBounds(page, pageSize);
        List studentList = studentDao.findPageListByName(name, pageBounds);
        PageList studentPageList = (PageList)studentList;
        return studentPageList;
    }

}
