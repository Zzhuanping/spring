package com.zhang.aop.annoaop;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testanno {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
       Calculator calculator = (Calculator) context.getBean(Calculator.class);
       calculator.div(12, 1);



    }
}
