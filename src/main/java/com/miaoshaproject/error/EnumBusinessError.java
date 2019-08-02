package com.miaoshaproject.error;

/**
 * Created with IDEA
 *
 * @author chong  liu
 * @create 2019/8/2 10:46
 */
public enum EnumBusinessError implements CommonError {
    //通用错误类型10001
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    //20000开头为用户相关错误信息定义
    USER_NOT_EXIST(20001,"用户不存在"),
    ;
    EnumBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
