package com.zhang.jie.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        User user1 = (User)context.getBean("demo");
        System.out.println("6 使用bean"+user1);
        context.close();
    }
}
