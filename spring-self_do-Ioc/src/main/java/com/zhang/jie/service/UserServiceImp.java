package com.zhang.jie.service;

import com.zhang.jie.anno.Bean;
import com.zhang.jie.anno.Di;
import com.zhang.jie.dao.UserDao;

@Bean
public class UserServiceImp implements UserService {

    @Di
    private UserDao dao;

    @Override
    public void add() {
        System.out.println("service do");

    }
}
