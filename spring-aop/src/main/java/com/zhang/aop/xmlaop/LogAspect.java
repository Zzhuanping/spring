package com.zhang.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Component //IoC管理
public class LogAspect {

    //  前置
    public void before(){
        System.out.println("前置通知before--->");

    }

//    后置
    public void after(@NotNull JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("后置通知: "+name+", 参数列表："+ Arrays.toString(args));
    }


//    最终通知
    public void afterReturningMethod(JoinPoint joinPoint,int result){
        String name = joinPoint.getSignature().getName();
        System.out.println("返回通知    "+name+"    "+result);

    }

//   异常通知
    public void aftererror(Throwable ex){
        System.out.println("异常通知error"+ex.toString());  //有错就运行

    }


//    环绕
    public Object around(ProceedingJoinPoint point){
        Object proceed = null;
        int i = 0;

        try {
            System.out.println("start   "+Arrays.toString(point.getArgs()));
             proceed = point.proceed(); //执行核心代码
              i = (int)point.proceed();

            System.out.println("end     "+point.getSignature().getName());
        }catch (Throwable e){
            System.out.println("somg error");

        } finally {
            System.out.println("最终结果    "+i);

        }

        return proceed;
    }

}
