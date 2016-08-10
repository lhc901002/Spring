package org.michaelliu.spring.beans.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael on 8/10/16.
 */
@XmlRootElement(name = "Transaction")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "accountId", "amount", "createTime" })
public class Transaction implements Serializable {

    private static final long serialVersionUID = 6084937797293837555L;

    private Long id;

    private Long accountId;

    private Integer amount;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
