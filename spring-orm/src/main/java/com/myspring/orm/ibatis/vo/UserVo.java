package com.myspring.orm.ibatis.vo;

import java.util.Date;

/**
 * 类UserVo
 *
 * @author liuhaocheng
 * @since 2016-06-13.
 */
public class UserVo {

    private Long id;

    private String name;

    private Date createTime;

    private String profileUrl;

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

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "createTime=" + createTime +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                '}';
    }

}
