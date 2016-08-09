package org.michaelliu.spring.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by michael on 2016/8/2.
 */
@XmlRootElement(name = "Account")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "name", "balance" })
public class Account implements Serializable {

    private static final long serialVersionUID = -1979894774396318892L;

    private Long id;

    private String name;

    private Integer balance;

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

    public void init() {
        System.out.println("Account created");
    }

    public void destroy() {
        System.out.println("Account destroyed");
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("balance", balance)
                .toString();
    }

}
