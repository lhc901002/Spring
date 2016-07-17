package org.michaelliu.spring.transaction.entity;

/**
 * Created by Michael on 6/30/16.
 */
public class Record {

    private Long id;

    private String name;

    private Integer balance;

    public Record() {}

    public Record(Long id, String name) {
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
