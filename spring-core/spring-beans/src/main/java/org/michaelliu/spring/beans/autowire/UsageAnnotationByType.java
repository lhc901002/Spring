package org.michaelliu.spring.beans.autowire;

import org.michaelliu.spring.beans.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Michael on 7/15/16.
 */
public class UsageAnnotationByType {

    private Long id;

    @Autowired
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
        return "UsageAnnotationByType{" +
                "id=" + id +
                ", userInfo=" + userInfo +
                '}';
    }

}
