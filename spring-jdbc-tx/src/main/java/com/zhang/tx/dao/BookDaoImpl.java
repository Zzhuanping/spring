package com.zhang.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate dataSource;

    //    根据图书id查询价格
    @Override
    public Integer getBookPriceByBookId(Integer bookid) {
        String sql = "select price from t_book where book_id = ?";
        return dataSource.queryForObject(sql, Integer.class, bookid);

    }
    //    更新库存
    @Override
    public void updateStock(Integer bookid) {
        String sql = "update t_book set stock = stock-1  where book_id = ?";
        dataSource.update(sql,bookid);


    }
    //更新用户余额
    @Override
    public void updateUserBalance(Integer userid, Integer price) {
        String sql = "update t_user set balance = balance - ? where user_id = ?";
        dataSource.update(sql,price,userid);


    }
}
