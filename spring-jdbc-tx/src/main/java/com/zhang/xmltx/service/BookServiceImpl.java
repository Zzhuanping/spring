package com.zhang.xmltx.service;


import com.zhang.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookid, Integer userid) {
//        查询图书价格
        Integer  price = bookDao.getBookPriceByBookId(bookid);
//        更新图书表的库存
        bookDao.updateStock(bookid);
//        更新用户余额,根据查询到的图书价格改变
        bookDao.updateUserBalance(userid,price);
    }
}
