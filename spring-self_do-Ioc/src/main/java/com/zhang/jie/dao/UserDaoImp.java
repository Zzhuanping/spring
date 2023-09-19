package com.zhang.jie.dao;

import com.zhang.jie.anno.Bean;

@Bean
public class UserDaoImp implements UserDao{

    @Override
    public void add() {
        System.out.println("dao do");
    }
}
