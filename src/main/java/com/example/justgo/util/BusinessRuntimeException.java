package com.example.justgo.util;

/**
 * @Auther: YYF
 * @Date: 2019/9/19 14:05
 */
public class BusinessRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Throwable rootCause;
    private String errorKey;
    private Integer errCode;
    private String[] errorParam;
    private Object[] errorObjectParam;


    public BusinessRuntimeException(ErrEnum errEnum) {
        super(errEnum.getErrMsg());
        this.errCode = errEnum.getErrCode();
        this.errorKey =errEnum.getErrMsg();
    }

    public BusinessRuntimeException() {
        super();
    }

    public BusinessRuntimeException(String arg0) {
        super(arg0);
        this.errorKey = arg0;
        rootCause = this;
    }

    public BusinessRuntimeException(Integer errCode, String arg0) {
        super(arg0);
        this.errCode = errCode;
        this.errorKey = arg0;
        rootCause = this;
    }

    public BusinessRuntimeException(String s, Throwable e) {
        this(s);
        if (e instanceof BusinessRuntimeException) {
            rootCause = ((BusinessRuntimeException) e).rootCause;
        } else {
            rootCause = e;
        }
    }

    public BusinessRuntimeException(Throwable e) {
        this("", e);
    }

    public BusinessRuntimeException(String key, Object[] objectParam) {
        this(key);
        this.errorObjectParam = objectParam;
    }



    public Throwable getRootCause() {
        return rootCause;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public Integer getErrCode() {
        return errCode;
    }



    public String[] getErrorParam() {
        return errorParam;
    }

    public void setErrorParam(String[] errorParam) {
        this.errorParam = errorParam;
    }

    public Object[] getErrorObjectParam() {
        return errorObjectParam;
    }

    public void setErrorObjectParam(Object[] errorObjectParam) {
        this.errorObjectParam = errorObjectParam;
    }
}
