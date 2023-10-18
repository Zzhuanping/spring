package com.zhang.tx;

import com.zhang.tx.config.SpringConfig;
import com.zhang.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {
    @Test
    public void testanno(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = (BookController) applicationContext.getBean("bookController", BookController.class);
        bookController.buyBook(1,1);

    }


}
