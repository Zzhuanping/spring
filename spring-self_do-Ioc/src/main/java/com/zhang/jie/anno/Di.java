package com.zhang.jie.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) //属性
@Retention(RetentionPolicy.RUNTIME)
public @interface Di { //注入属性


}
