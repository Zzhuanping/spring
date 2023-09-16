package com.zhang.jie.auto.service;

import com.zhang.jie.auto.controller.UserController;
import com.zhang.jie.auto.dao.UserDao;
import com.zhang.jie.auto.dao.UserDaoimp;

public class UserServiceimp implements UserService{
    private UserDao userDao;


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void userAddService() {
        System.out.println("userService方法执行");

        userDao.userAddDao();

    }
}
