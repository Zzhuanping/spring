package com.zhang.jie.auto;

import com.zhang.jie.auto.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController controller = (UserController) context.getBean("controller");
        controller.addUserconterller();
    }
}
