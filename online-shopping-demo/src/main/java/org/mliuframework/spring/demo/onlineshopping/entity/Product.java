package org.mliuframework.spring.demo.onlineshopping.entity;

import java.util.Date;

/**
 * Created by Michael on 6/29/16.
 */
public class Product {

    private Long id;

    private String name;

    private String model;

    private Byte type;

    private String imageUrl;

    private Integer price;

    private Integer balance;

    private Integer salesVolume;

    private Integer commentCount;

    private Integer collectCount;

    private Integer popularity;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    public Product() {}

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
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

        private String name;

        private String model;

        private Byte type;

        private String imageUrl;

        private Integer price;

        private Integer balance;

        private Integer salesVolume;

        private Integer commentCount;

        private Integer collectCount;

        private Integer popularity;

        private Byte status;

        private Date createTime;

        private Date updateTime;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setType(Byte type) {
            this.type = type;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setPrice(Integer price) {
            this.price = price;
            return this;
        }

        public Builder setBalance(Integer balance) {
            this.balance = balance;
            return this;
        }

        public Builder setSalesVolume(Integer salesVolume) {
            this.salesVolume = salesVolume;
            return this;
        }

        public Builder setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
            return this;
        }

        public Builder setCollectCount(Integer collectCount) {
            this.collectCount = collectCount;
            return this;
        }

        public Builder setPopularity(Integer popularity) {
            this.popularity = popularity;
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

        public Product build() {
            return new Product(this);
        }

    }

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.model = builder.model;
        this.type = builder.type;
        this.imageUrl = builder.imageUrl;
        this.price = builder.price;
        this.balance = builder.balance;
        this.salesVolume = builder.salesVolume;
        this.commentCount = builder.commentCount;
        this.collectCount = builder.collectCount;
        this.popularity = builder.popularity;
        this.status = builder.status;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
    }

}
