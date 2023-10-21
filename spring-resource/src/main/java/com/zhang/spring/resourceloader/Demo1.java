package com.zhang.spring.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;


public class Demo1 {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext();
        Resource resource = applicationContext.getResource("mytest.txt");
        System.out.println(resource.getFilename());
    }
}
