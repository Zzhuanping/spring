package com.zhang.jie.auto.controller;

import com.zhang.jie.auto.service.UserService;
import com.zhang.jie.auto.service.UserServiceimp;

public class UserController {

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    private UserService userService;

    public UserController() {
    }

    public void addUserconterller(){

        System.out.println("控制层方法执行");
        userService.userAddService();

    }


}
