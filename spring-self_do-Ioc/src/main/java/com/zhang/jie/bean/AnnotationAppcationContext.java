package com.zhang.jie.bean;

import com.zhang.jie.anno.Bean;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationAppcationContext implements ApplicationContext{

    private  Map<Class,Object> beanFactory = new HashMap<>();//    创建map集合，存放Bean对象
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }


//    包的扫描规则，包及其子包--创建有参构造，传递参数


    public AnnotationAppcationContext(@NotNull String basePackage)  {
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
                loadBean(new File(rootPath));

            }
        }catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                InstantiationException | IllegalAccessException e){
            System.out.println(e);
            throw  new RuntimeException();

        }

    }

    private  void loadBean(@NotNull File file) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
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
                String pathwithclass = child.getAbsolutePath();
                //        判断当前文件的类型是否.class
                    if (pathwithclass.contains(".class")){
                        //        路径中的.替换成\ 把.class去掉
                       String allname =  pathwithclass.replaceAll("\\\\",".")
                                            .replace(".class","");
                        //        判断类上是否有bean注解，如果有就用反射实例化过程
                            //获取类的class
                        Class<?> aClass = Class.forName(allname);
                        // 判断不是接口
                        if (!aClass.isInterface()){
                            // 判断是否有注解
                            Bean annotation = (Bean)aClass.getAnnotation(Bean.class);
                            if (annotation != null ){
//                                实例化
                                Object instance = aClass.getConstructor().newInstance();
                                //        实例化之后，反倒map集合beanFactory
                                    // 判断当前类是否有接口，让接口class作为map的key
                                    if(aClass.getInterfaces().length > 0){
                                        beanFactory.put(aClass.getInterfaces()[0],instance);
                                    }else {
                                        beanFactory.put(aClass,instance);

                                    }

                            }
                        }
                    }






            }

    }

}


    }

    @Test
    public void test(){
        AnnotationAppcationContext context = new AnnotationAppcationContext("com.zhang.jie");
    }


}
