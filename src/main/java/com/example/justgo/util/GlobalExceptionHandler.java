package com.example.justgo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: YYF
 * @Date: 2019/9/19 14:16
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseBean exceptionHandler(Exception e){
        if (e instanceof BusinessRuntimeException){
            BusinessRuntimeException be = (BusinessRuntimeException) e;
            LOGGER.error("exception{}", e);
            Integer errCode = be.getErrCode() == null ? ErrEnum.SYS_ERR.getErrCode() : be.getErrCode();
            return ResultUtil.error(errCode, be.getMessage());
        }

        LOGGER.error("exception{}", e);
        String errMsg = StringUtils.isEmpty(e.getMessage()) ? ErrEnum.SYS_ERR.getErrMsg() : e.getMessage();
        return ResultUtil.error(ErrEnum.SYS_ERR.getErrCode(), errMsg);
    }
}
