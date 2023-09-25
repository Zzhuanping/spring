package com.zhang.aop.xmlaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testanno {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanaop.xml");
       Calculator calculator = (Calculator) context.getBean(Calculator.class);
       calculator.add(1,1);



    }
}
