package com.zhang.tx;

import com.zhang.tx.controller.BookController;
import com.zhang.tx.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class Testtx {

    @Autowired
    private BookController bookController;

    @Test
    public void test01(){
//    Integer[] bookids = {1,2};
//        bookController.buymanybooks(bookids,1);

    bookController.buyBook(1,1);

    }
}
