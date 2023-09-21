package com.zhang.aop.example;


//代理类
public class CalculatorStaticproxy implements Calculator{

//    将被代理目标对象传递进来
    private Calculator calculator;
    public CalculatorStaticproxy(Calculator calculator) {       //用构造方法获取目标类也就是核心业务所在
        this.calculator = calculator;
    }



    @Override
    public int add(int i, int j) {
        System.out.println("[log]--add start");
        calculator.add(i,j);
        System.out.println("[log]--add end");

        return 0;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[log]--sub start");
        int result = calculator.sub(i,j);
        System.out.println("[log]--sub end");
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[log]--mul start");
        int result = calculator.mul(i,j);
        System.out.println("[log]--mul end");
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[log]--div start");
        int result = calculator.div(i,j);
        System.out.println("[log]--div end");
        return result;
    }
}
