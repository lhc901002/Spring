package org.michaelliu.spring.mvc.vo;

/**
 * Created by Michael on 7/11/16.
 */
public class MessageVo {

    private Integer status;

    private String statusInfo;

    public MessageVo() {}

    public MessageVo(Integer status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

}
