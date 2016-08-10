package org.michaelliu.spring.beans.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by Michael on 8/10/16.
 */
public class TransactionVo implements Serializable {

    private static final long serialVersionUID = -7186286397523822784L;

    private Long id;

    private Long fromAccountId;

    private Long toAccountId;

    private Integer amount;

    private Byte type;

    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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
