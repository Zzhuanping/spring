package com.zhang.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

//    核心--目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //    返回任意代理对象
    public Object getProxy(){

        /*
        *  参数
        *   1. Classloader:加载动态生成代理类的加载器
        *   2. interfaces ：目标对象实现的所有接口class类型的数组
        *   3. invocation：设置代理对象实现目标对象方法的过程
        *
        * */


        //1.
                ClassLoader classLoader = target.getClass().getClassLoader();

        //2.
        Class<?>[] interfaces = target.getClass().getInterfaces();

        //3.匿名内部类
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                * Object proxy, 代理对象
                * Method method, 核心方法
                * Object[] args:method()的参数
                *
                * */

                System.out.println("动态代理--start   "+method.getName()+ "    "+ Arrays.toString(args));
                Object ok = method.invoke(target ,args);
                System.out.println("动态代理--end");


                return ok;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
