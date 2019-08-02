package com.miaoshaproject.service;

import com.miaoshaproject.service.model.UserModel;

/**
 * Created with IDEA
 *
 * @author chong  liu
 * @create 2019/8/1 10:46
 */
public interface IUserService {
    UserModel getUserById(Integer id);
}
