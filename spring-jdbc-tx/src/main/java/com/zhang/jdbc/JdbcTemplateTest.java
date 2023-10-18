package com.zhang.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;


//    对数据库添加
    @Test
    public void testAdd(){
        String sql = "insert into zhang value(?,?,?)" ;//sql语句,采用预编译的方法执行sql代码


//        调用jdbcTemplate中的方法完成操作
    Object[] line = {"nihao",1}; //可以将数组传入updata方法
       int rows =  jdbcTemplate.update(sql,"Bili",2,"Russia"); // 按照 ? 顺序传入值，返回值是影响的行数
        System.out.println("操作结果"+rows);
    }

//    修改

    @Test
    public void alertTable(){

        String sql = "update zhang set user_name=? where user_name=?"; //修改名字
        int i = jdbcTemplate.update(sql,"lisa","Bili");
        System.out.println("操作结果： "+i);

    }

//    删除
    @Test
    public void deleteValue(){
        String sql = "delete from zhang where user_name=?";
        int i  = jdbcTemplate.update(sql,"Luccy");
        System.out.println("result "+i);

    }

//    查询    返回对象
    @Test
    public void selectObject(){
    String sql ="select * from zhang where user_name = ?";

       /* 手动封装接口实现查询功能
       Stu student = jdbcTemplate.queryForObject(sql,(rs,rowNum)->{
            Stu stu = new Stu();
            stu.setUser_pw(rs.getInt("user_pw"));
            stu.setUser_name(rs.getString("user_name"));
            stu.setUser_address(rs.getString("user_address"));

            return stu;
        },"Luccy");
        */
        Stu stu = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Stu.class),"Luccy");  //使用已经封装好的对象直接传入实体类字节文件



    }

//    查询    返回list集合
        @Test
        public void queryList(){
        String sql = "select * from zhang";
            List<Stu> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Stu.class));

            System.out.println(query.get(0));


        }


//    查询    返回单个值

    @Test
    public void getSloe(){
        String sql = "select user_name from zhang where user_pw = ?";
        String username = jdbcTemplate.queryForObject(sql,String.class,12);
        System.out.println("名字是 "+username);


    }
}
