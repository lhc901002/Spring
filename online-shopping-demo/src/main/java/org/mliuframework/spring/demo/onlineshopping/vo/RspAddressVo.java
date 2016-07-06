package org.mliuframework.spring.demo.onlineshopping.vo;

/**
 * Created by Michael on 6/28/16.
 */
public class RspAddressVo extends RspVo {

    private AddressVo address;

    public RspAddressVo() {}

    public RspAddressVo(Integer status, String statusInfo) {
        super(status, statusInfo);
    }

    public AddressVo getAddress() {
        return address;
    }

    public void setAddress(AddressVo address) {
        this.address = address;
    }

}
