package com.zhang;

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
            System.out.println(userService);
            userService.add();

        }
    }
}