package com.zhang.spring.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

public class FileSystemResourceDemo {

    public static void main(String[] args) {

        loadfileresource("D:\\imsdk_config");//绝对路径

        loadfileresource("mytest.txt");//相对路径
    }

    static void loadfileresource(String path){
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        System.out.println(fileSystemResource.getFilename()+"111"+fileSystemResource.getDescription());
        try{
            InputStream in = fileSystemResource.getInputStream();
            byte[] b = new byte[120];
            while (in.read(b)!= -1){
                System.out.println(new String(b));
            }
        }catch (IOException e){

        }



    }

}
