package com.zhang.xmltx.controller;

import com.zhang.xmltx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;



    public void  buyBook(Integer bookid,Integer userid){
        bookService.buyBook(bookid,userid);


    }

    }

