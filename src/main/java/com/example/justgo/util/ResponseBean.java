package com.example.justgo.util;

import java.io.Serializable;

/**
 * @Auther: YYF
 * @Date: 2019/9/19 14:18
 */
public class ResponseBean implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public ResponseBean(){
        super();
    }

    public ResponseBean(Integer code, String msg){
        this.code =code;
        this.msg = msg;
    }
    public ResponseBean(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseBean(ErrEnum errEnum){
        this.code = errEnum.getErrCode();
        this.msg = errEnum.getErrMsg();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
