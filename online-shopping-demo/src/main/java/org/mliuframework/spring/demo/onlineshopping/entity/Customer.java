package org.mliuframework.spring.demo.onlineshopping.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class Customer {

    private Long id;

    private String nickName;

    private String surName;

    private String givenName;

    /**
     * 1 - male, 2 - female, 0 - unknown
     */
    private Byte gender;

    private String phoneNo;

    private String email;

    private String headImageUrl;

    private Integer starLevel;

    private Integer score;

    private Byte [] details;

    private Date createTime;

    private Date updateTime;

    public Customer() {}

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte[] getDetails() {
        return details;
    }

    public void setDetails(Byte[] details) {
        this.details = details;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean hasAllRequiredField() {
        return StringUtils.isNotEmpty(nickName) && StringUtils.isNotEmpty(phoneNo) &&
                StringUtils.isNotEmpty(email);
    }

    /**
     * create builder for customer object
     */
    public static class Builder {

        private Long id;

        private String nickName;

        private String surName;

        private String givenName;

        private Byte gender;

        private String phoneNo;

        private String email;

        private String headImageUrl;

        private Integer starLevel;

        private Integer score;

        private Byte [] details;

        private Date createTime;

        private Date updateTime;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder setGender(Byte gender) {
            this.gender = gender;
            return this;
        }

        public Builder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setHeadImageUrl(String headImageUrl) {
            this.headImageUrl = headImageUrl;
            return this;
        }

        public Builder setStarLevel(Integer starLevel) {
            this.starLevel = starLevel;
            return this;
        }

        public Builder setScore(Integer score) {
            this.score = score;
            return this;
        }

        public Builder setDetails(Byte[] details) {
            this.details = details;
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

        public Customer build() {
            return new Customer(this);
        }

    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.nickName = builder.nickName;
        this.surName = builder.surName;
        this.givenName = builder.givenName;
        this.gender = builder.gender;
        this.phoneNo = builder.phoneNo;
        this.email = builder.email;
        this.headImageUrl = builder.headImageUrl;
        this.starLevel = builder.starLevel;
        this.score = builder.score;
        this.details = builder.details;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
    }

}
