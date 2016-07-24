package org.michaelliu.spring.beans;

/**
 * Created by Michael on 7/14/16.
 */
public class Account {

    private Long id;

    private String name;

    private UserInfo userInfo;

    public Account() {
    }

    public Account(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void init() {
        System.out.println("Account init!");
    }

    public void complete() {
        System.out.println("Account complete!");
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }

}
