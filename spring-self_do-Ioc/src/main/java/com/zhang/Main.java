package com.zhang;

import com.zhang.jie.bean.AnnotationAppcationContext;
import com.zhang.jie.bean.ApplicationContext;
import com.zhang.jie.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationAppcationContext("com.zhang.jie");
        UserService userService = (UserService) context.getBean(UserService.class);
                userService.add();


    }
}