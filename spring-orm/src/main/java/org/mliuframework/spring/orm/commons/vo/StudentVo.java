package org.mliuframework.spring.orm.commons.vo;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Michael on 7/11/16.
 */
public class StudentVo {

    private Long id;

    private String name;

    private Integer age;

    private String createTime;

    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean containAllRequiredField() {
        return null != id || StringUtils.isNotEmpty(name) || null != age ||
                StringUtils.isNotEmpty(createTime) || StringUtils.isNotEmpty(updateTime);
    }

}
