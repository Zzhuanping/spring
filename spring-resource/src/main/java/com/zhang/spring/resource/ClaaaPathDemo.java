package com.zhang.spring.resource;


import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

//访问类路径下的资源
public class ClaaaPathDemo {


    public static void main(String[] args) throws IOException {
        loadclass("mytest.txt");
    }

    public static void loadclass(String path) throws IOException {


        ClassPathResource classPathResource = new ClassPathResource(path);
        System.out.println(classPathResource.getFilename()+classPathResource.getInputStream().read());

        byte[] b = new byte[10];
        InputStream inputStream = classPathResource.getInputStream();
        while(inputStream.read(b) != -1){
            System.out.println(new String(b));
        }


    }
}
