package com.zhang;

import com.zhang.jie.bean.AnnotationAppcationContext;
import com.zhang.jie.bean.ApplicationContext;
import com.zhang.jie.service.UserService;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static class TestUser {

        @Test
        public void testUser(){
            ApplicationContext context =
                    new AnnotationAppcationContext("com.zhang.jie");
            UserService userService = (UserService) context.getBean(UserService.class);
            System.out.println();
            userService.add();

        }
    }
}