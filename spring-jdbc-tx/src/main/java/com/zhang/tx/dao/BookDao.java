package com.zhang.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;

public interface BookDao {



    Integer getBookPriceByBookId(Integer bookid);


    void updateStock(Integer bookid);

    void updateUserBalance(Integer userid, Integer price);
}
