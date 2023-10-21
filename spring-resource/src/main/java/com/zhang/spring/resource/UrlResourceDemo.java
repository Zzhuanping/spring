package com.zhang.spring.resource;

import org.springframework.core.io.UrlResource;

import java.io.IOException;

public class UrlResourceDemo  {
//    访问网络资源
public static void main(String[] args) {


    //访问前缀是http
    loadurl("http://www.baidu.com");

//    访问前缀是file
    loadurl("file:mytest.txt");

}


    public static void loadurl(String path)  {

        try{
//            创建Resource类的对象
            UrlResource url = new UrlResource(path);
            System.out.println(url.getFilename()+url.getURL()+url.getDescription()+url.getInputStream().read());

        }catch (IOException ignored){

        }


    }


}
