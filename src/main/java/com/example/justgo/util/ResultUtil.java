package com.example.justgo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: YYF
 * @Date: 2019/9/19 14:23
 */
public class ResultUtil {
    public static ResponseBean success(){
        return success("");
    }

    public static ResponseBean success(Object object){
        return new ResponseBean(ErrEnum.SUCCESS.getErrCode(), ErrEnum.SUCCESS.getErrMsg(), object);
    }

    public static ResponseBean success(String key, Object object){
        Map map = new HashMap();
        map.put(key, object);
        return success(map);
    }

    public static ResponseBean error(Integer code, String message){
        return new ResponseBean(code, message, "");
    }

    public static ResponseBean error(ErrEnum resultEnum){
        return error(resultEnum.getErrCode(), resultEnum.getErrMsg());
    }

}
