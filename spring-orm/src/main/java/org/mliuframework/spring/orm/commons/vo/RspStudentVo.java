package org.mliuframework.spring.orm.commons.vo;

import org.mliuframework.spring.orm.commons.entity.Student;

/**
 * Created by Michael on 7/11/16.
 */
public class RspStudentVo extends RspVo {

    private Student student;

    public RspStudentVo() {}

    public RspStudentVo(Integer status, String statusInfo) {
        super(status, statusInfo);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
