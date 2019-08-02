package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EnumBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author chong  liu
 * @create 2019/8/2 11:31
 */
public class BaseController {
    //定义ExceptionHandler解决未被Controller层吸收的Exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMsg", businessException.getErrMsg());
        }else{
            responseData.put("errCode", EnumBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", EnumBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(responseData,"fail");
//        CommonReturnType commonReturnType = new CommonReturnType();
//        commonReturnType.setStatus("fail");
//
//        commonReturnType.setData(responseData);
//        return commonReturnType;
    }
}
