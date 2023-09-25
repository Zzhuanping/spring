package com.zhang.junit.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class Testclass {

//    注入
    @Autowired
    private User user;

    @Test
    public void testJUnit5(){
        user.run();
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user =(User) context.getBean("user");
        user.run();

    }


}
