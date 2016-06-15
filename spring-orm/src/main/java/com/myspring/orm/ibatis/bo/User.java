package com.myspring.orm.ibatis.bo;

import java.util.Arrays;
import java.util.Date;

public class User {

    private Long id;

    private String name;

    private Date createTime;

    private byte [] profile;

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "createTime=" + createTime +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", profile=" + Arrays.toString(profile) +
                '}';
    }
}
