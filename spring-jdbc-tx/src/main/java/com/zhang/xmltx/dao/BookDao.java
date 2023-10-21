package com.zhang.xmltx.dao;

public interface BookDao {



    Integer getBookPriceByBookId(Integer bookid);


    void updateStock(Integer bookid);

    void updateUserBalance(Integer userid, Integer price);
}
