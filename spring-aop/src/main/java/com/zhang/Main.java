package com.zhang;

import com.zhang.aop.example.*;
public class Main {
    public static void main(String[] args) {


        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImp());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.sub(1,1);

    }
}