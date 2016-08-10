package org.michaelliu.spring.beans.vo;

import java.io.Serializable;

/**
 * Created by Michael on 8/10/16.
 */
public class TransactionVo implements Serializable {

    private static final long serialVersionUID = -7186286397523822784L;

    private Long id;

    private Long accountId;

    private Integer amount;

    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
