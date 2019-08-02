package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.UserDOMapper;
import com.miaoshaproject.dao.UserPasswordMapper;
import com.miaoshaproject.dataObject.UserDO;
import com.miaoshaproject.dataObject.UserPassword;
import com.miaoshaproject.service.IUserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author chong  liu
 * @create 2019/8/1 10:46
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO=userDOMapper.selectByPrimaryKey(id);
        if(userDO == null){
            return null;
        }
        UserPassword userPassword = userPasswordMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO,userPassword);
    }
    public UserModel convertFromDataObject(UserDO userDO, UserPassword userPassword){
        if(userDO == null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        if(userPassword != null){
            userModel.setEncriptPassword(userPassword.getEncrptPassword());
        }
        return userModel;
    }
}
