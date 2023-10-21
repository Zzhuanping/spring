package com.zhang.spring.resourceloaderaware;

import com.zhang.spring.di.ResourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class test {
    public static void main(String[] args) {
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.getBean(ResourceBean.class).parse();


    }

}
