package com.example.justgo.util;

public enum ErrEnum {
    SUCCESS(0,""),
    SYS_ERR (1,"shibai");

    private Integer errCode;
    private String errMsg;

    ErrEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
