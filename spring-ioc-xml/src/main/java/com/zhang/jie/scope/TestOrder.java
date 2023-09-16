package com.zhang.jie.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder {

    @Test
    public void testOrder(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Order order = (Order) context.getBean("orders");
        System.out.println(order);

        Order order1 = (Order) context.getBean("orders");
        System.out.println(order1);

    }
}
