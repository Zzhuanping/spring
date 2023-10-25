package com.zhang.validator.two;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnno {

    public static void main(String[] args) {

        ApplicationContext a = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidator bean = a.getBean(MyValidator.class);
        User user = new User();
        user.setName(" ");
        user.setAge(1001);
        System.out.println(bean.judgeRight(user));

    }



}
