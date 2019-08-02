package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EnumBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.IUserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author chong  liu
 * @create 2019/8/1 10:42
 */
@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id")Integer id) throws BusinessException {
        //调用service服务获取对应用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);
        //若获取的对应用户信息不存在
        if(userModel == null){
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }
        return CommonReturnType.create(userModel);
    }


}
