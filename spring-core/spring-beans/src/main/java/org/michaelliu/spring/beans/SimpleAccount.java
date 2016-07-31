package org.michaelliu.spring.beans;

/**
 * Created by michael on 2016/7/31.
 */
public class SimpleAccount {

    private Long id;

    private String name;

    private Integer balance;

    public SimpleAccount() {
    }

    public SimpleAccount(Long id, String name, Integer balance) {
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

    @Override
    public String toString() {
        return "SimpleAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

}
