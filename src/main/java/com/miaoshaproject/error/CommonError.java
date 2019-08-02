package com.miaoshaproject.error;

/**
 * Created with IDEA
 *
 * @author chong  liu
 * @create 2019/8/2 10:43
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);

}
