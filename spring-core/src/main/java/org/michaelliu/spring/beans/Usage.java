package org.michaelliu.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Michael on 7/15/16.
 */
public class Usage {

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

    public void init() {
        System.out.println("Usage init!");
    }

    @Override
    public String toString() {
        return "Usage{" +
                "id=" + id +
                ", userInfo=" + userInfo +
                '}';
    }

}
