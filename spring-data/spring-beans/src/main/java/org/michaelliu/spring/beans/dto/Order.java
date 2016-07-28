package org.michaelliu.spring.beans.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael on 6/29/16.
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -8090191873294992163L;

    private Long id;

    private Long customerId;

    private Integer totalPrice;

    private Long productCount;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public static class Builder {

        private Long id;

        private Long customerId;

        private Long productCount;

        private Integer totalPrice;

        private Byte status;

        private Date createTime;

        private Date updateTime;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setProductCount(Long productCount) {
            this.productCount = productCount;
            return this;
        }

        public Builder setTotalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder setStatus(Byte status) {
            this.status = status;
            return this;
        }

        public Builder setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Order build() {
            return new Order(this);
        }

    }

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerId = builder.customerId;
        this.productCount = builder.productCount;
        this.totalPrice = builder.totalPrice;
        this.status = builder.status;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
    }

}
