package org.michaelliu.spring.beans.autowire;

import org.michaelliu.spring.beans.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by michael on 2016/7/29.
 */
public class UsageAnnotationByName {

    private Long id;

    @Autowired
    @Qualifier("newUserInfo")
    private UserInfo userInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UsageAnnotationByName{" +
                "id=" + id +
                ", userInfo=" + userInfo +
                '}';
    }

}
