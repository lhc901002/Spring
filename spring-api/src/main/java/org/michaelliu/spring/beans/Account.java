package org.michaelliu.spring.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by michael on 2016/8/2.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = -1979894774396318892L;

    private Long id;

    private String name;

    private Integer balance;

    private Date createTime;

    private Date updateTime;

    public Account() {
    }

    public Account(Long id, String name, Integer balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void init() {
        System.out.println("Account created");
    }

    public void destroy() {
        System.out.println("Account destroyed");
    }

}
