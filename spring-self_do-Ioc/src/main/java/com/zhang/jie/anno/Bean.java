package com.zhang.jie.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //作用范围 类上
@Retention(RetentionPolicy.RUNTIME) //运行时机--运行时
public @interface Bean {  //创建对象
}
