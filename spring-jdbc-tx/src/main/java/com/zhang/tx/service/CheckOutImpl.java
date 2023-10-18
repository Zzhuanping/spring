package com.zhang.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckOutImpl implements CheckOutService{
    @Autowired
    private BookService bookService;


    @Override
    @Transactional
    public void checkout(Integer[] bookids, Integer userid) {
        for (Integer bookid:bookids ) {
            bookService.buyBook(bookid,userid);
        }
    }
}
