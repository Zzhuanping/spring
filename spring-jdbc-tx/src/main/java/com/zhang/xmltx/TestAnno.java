package com.zhang.xmltx;

import com.zhang.xmltx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans-xml.xml")
public class TestAnno {

    @Autowired
    private BookController bookController;

    @Test
    public void testanno(){
      bookController.buyBook(1,1);

    }


}
