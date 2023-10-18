package com.zhang.tx.controller;

import com.zhang.tx.service.BookService;
import com.zhang.tx.service.CheckOutImpl;
import com.zhang.tx.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;



    public void  buyBook(Integer bookid,Integer userid){
        bookService.buyBook(bookid,userid);


    }

    @Autowired
    private CheckOutService checkOut;

    public void buymanybooks(Integer[] bookids,Integer userid){
        checkOut.checkout(bookids,userid);

    }

}
