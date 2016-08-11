package org.michaelliu.demo.spring.mybatis.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael on 7/14/16.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = -5533773720712391647L;

    private Long id;

    private String name;

    private Integer balance;

    private Date createTime;

    private Date updateTime;

    public Account() {}

    public Account(String name, Integer balance) {
        this(null, name, balance);
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("balance", balance)
                .append("createTime", createTime)
                .append("updateTime", updateTime)
                .toString();
    }

}
