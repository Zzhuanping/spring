package com.zhang.aop.example;


//带有日志的计算器
public class CalculatorLogImp implements Calculator{


    @Override
    public int add(int i, int j) {


        int result = i +j ;
        System.out.println("【日志】 add方法启动 参数是"+i+"----"+j);
        System.out.println("方法内部： result="+result);
        System.out.println("【日志】 add方法结束 结果是" +result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j ;
        System.out.println("【日志】 sub方法启动 参数是"+i+"----"+j);
        System.out.println("方法内部： result="+result);
        System.out.println("【日志】 sub方法结束 结果是" +result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j ;
        System.out.println("【日志】 mul方法启动 参数是"+i+"----"+j);
        System.out.println("方法内部： result="+result);
        System.out.println("【日志】 mul方法结束 结果是" +result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j ;
        System.out.println("【日志】 div方法启动 参数是"+i+"----"+j);
        System.out.println("方法内部： result="+result);
        System.out.println("【日志】 div方法结束 结果是" +result);
        return result;
    }
}
