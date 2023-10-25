package com.zhang.validator.three;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {

    @Test
    public void testUser(){
        ApplicationContext a = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService bean = a.getBean(MyService.class);
        User user = new User();
        user.setName("jack");
        user.setPhone("qyy");
        System.out.println(bean.testMethod(user));


    }
}
