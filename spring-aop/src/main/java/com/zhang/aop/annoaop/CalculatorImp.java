package com.zhang.aop.annoaop;

import org.springframework.stereotype.Component;

@Component
//普通实现类
public class CalculatorImp implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i +j ;
        System.out.println("方法内部： result="+result);

        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i  - j ;
        System.out.println("方法内部： result="+result);

        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j ;
        System.out.println("方法内部： result="+result);

        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i  / j ;
        System.out.println("方法内部： result="+result);
        return result;
    }
}
