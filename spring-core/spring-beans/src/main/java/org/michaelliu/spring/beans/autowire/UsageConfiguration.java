package org.michaelliu.spring.beans.autowire;

import org.michaelliu.spring.beans.UserInfo;

/**
 * Created by michael on 2016/7/29.
 */
public class UsageConfiguration {

    private Long id;

    private UserInfo newUserInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getNewUserInfo() {
        return newUserInfo;
    }

    public void setNewUserInfo(UserInfo newUserInfo) {
        this.newUserInfo = newUserInfo;
    }

    @Override
    public String toString() {
        return "UsageConfiguration{" +
                "id=" + id +
                ", newUserInfo=" + newUserInfo +
                '}';
    }

}
