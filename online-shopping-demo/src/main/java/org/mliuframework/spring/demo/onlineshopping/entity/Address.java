package org.mliuframework.spring.demo.onlineshopping.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created by Michael on 6/27/16.
 */
public class Address {

    private Long id;

    private Long customerId;

    private String country;

    private String province;

    private String city;

    private String street;

    private String zipCode;

    /** 1 permanent address, 2 mailing address */
    private Byte type;

    /** true for valid, false no longer in use */
    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public Address() {}

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public Boolean hasAllRequiredFields() {
        Boolean result = true;
        if (null == customerId || StringUtils.isEmpty(country) ||
                StringUtils.isEmpty(province) || StringUtils.isEmpty(city) ||
                StringUtils.isEmpty(street) || StringUtils.isEmpty(zipCode) ||
                null == type) {
            result = false;
        }
        return result;
    }

    /**
     * create builder for address object
     */
    public static class Builder {

        private Long id;

        private Long customerId;

        private String country;

        private String province;

        private String city;

        private String street;

        private String zipCode;

        private Byte type;

        private Boolean status;

        private Date createTime;

        private Date updateTime;

        public Builder() {}

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setType(Byte type) {
            this.type = type;
            return this;
        }

        public Builder setStatus(Boolean status) {
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

        /**
         * build address object
         * @return newly created address object
         */
        public Address build() {
            return new Address(this);
        }

    }

    private Address(Builder builder) {
        this.id = builder.id;
        this.customerId = builder.customerId;
        this.country = builder.country;
        this.province = builder.province;
        this.city = builder.city;
        this.street = builder.street;
        this.zipCode = builder.zipCode;
        this.type = builder.type;
        this.status = builder.status;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
    }

}
