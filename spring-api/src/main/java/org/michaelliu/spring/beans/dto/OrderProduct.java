package org.michaelliu.spring.beans.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael on 7/1/16.
 */
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = -2098817341097994453L;

    private Long id;

    private Long orderId;

    private Long productId;

    private Long productCount;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
