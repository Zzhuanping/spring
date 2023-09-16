package com.zhang.jie.bean;

import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationAppcationContext implements ApplicationContext{



    private Map<Class,Object> beanFactory = new HashMap<>();//    创建map集合，存放Bean对象
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }


//    包的扫描规则，包及其子包--创建有参构造，传递参数


    public static void AnnotationAppcationContext(String basePackage)  {
//        设置包的扫描规则
/*
1. 把.换成斜杠\
2. 获取包的绝对路径

        */
//        1

        try{
            String packagePath = basePackage.replaceAll("\\.","\\\\");
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packagePath);

//            System.out.println(packagePath.equals(basePackage)+"        "+resources.hasMoreElements());

            while(resources.hasMoreElements()){
                URL url = resources.nextElement(); //绝对路径
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

//截取 filepath 固定前缀长度
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());

//                扫描包
//                loadBean(new File(filePath));

            }
        }catch (IOException e){

            throw  new RuntimeException();
        }

    }

    private void loadBean(File file) {
//        判断是否文件夹
if (file.isDirectory()){
    //获取里面的所有内容
    File[] childrenFiles = file.listFiles(); //得到文件，文件夹等
//判断文件夹是否为空，直接返回，反之直接遍历得到每一个file对象继续判断
        if (childrenFiles ==null || childrenFiles.length == 0){
            return;
        }
//        遍历得到的file对象不是文件夹而是文件
    for (File child:childrenFiles) {


            if (child.isDirectory()){
                loadBean(child); //递归遍历
            }else {
                //         得到的包路径+类名称部分--字符串的截取
                child.getAbsolutePath();
                //        判断当前文件的类型是否.class

//        路径中的.替换成\ 把.class去掉

//        判断类上是否有bean注解，如果有就用反射实例化过程

//        实例化之后，反倒map集合beanFactory

            }

    }

}


    }

    @Test
    public void test(){
        AnnotationAppcationContext("com.zhang.jie");

    }


}
