package com.miaoshaproject.response;

/**
 * Created with IDEA
 *
 * @author chong  liu
 * @create 2019/8/2 10:23
 */
public class CommonReturnType {

    private String status;  //表明对应请求的返回处理结果,"success"或"fail"

    private Object data;    //若status为success,则data返回前端需要的json数据
                  //若status=fail,则data内使用通用的错误代码格式

    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
