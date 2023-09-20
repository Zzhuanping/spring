package com.zhang.aop.example;


//代理类
public class CalculatorStaticproxy implements Calculator{

//    将被代理目标对象传递过来
    private Calculator calculator;

    public CalculatorStaticproxy(Calculator calculator) {
        this.calculator = calculator;
    }



    @Override
    public int add(int i, int j) {



        return 0;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
