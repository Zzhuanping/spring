package com.zhang.jie.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

public class MyBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


        System.out.println("5 bean的后置处理器--在初始化以后执行");
        System.out.println(beanName+"::"+ bean);

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("3 bean的后置处理器--在初始化之前启动");
        System.out.println(beanName+"::"+ bean);

        return bean;
    }
}
