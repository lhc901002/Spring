package org.michaelliu.spring.beans.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
@XmlType(propOrder = { "id", "fromAccountId", "toAccountId", "amount", "type", "createTime" })
public class Transaction implements Serializable {

    private static final long serialVersionUID = 6084937797293837555L;

    private Long id;

    private Long fromAccountId;

    private Long toAccountId;

    private Integer amount;

    private Byte type;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("fromAccountId", fromAccountId)
                .append("toAccountId", toAccountId)
                .append("amount", amount)
                .append("type", type)
                .append("createTime", createTime)
                .toString();
    }

}
