package com.zhang.jie.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestJdbc {

    @Test
    public void Demo1(){

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("10086");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");


    }


    @Test
    public void Demo2() throws SQLException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource druid = (DruidDataSource)context.getBean("DruidDataSource");
        System.out.println(druid.getPassword());

    }

}
