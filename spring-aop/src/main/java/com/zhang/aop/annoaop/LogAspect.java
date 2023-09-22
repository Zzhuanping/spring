package com.zhang.aop.annoaop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面类
@Component //Ioc管理
@Aspect  //注明切面类的注解
public class LogAspect {

    //    设置切入点和通知类型
        //切入点表达式execution()
    @Before(value = "execution(public int com.zhang.aop.annoaop.CalculatorImp.*(..))") //类中的所有方法的任意参数
    public void before(){
        System.out.println("前置通知before--->");

    }

    @After(value = "execution(public int com.zhang.aop.annoaop.CalculatorImp.add(..))")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("后置通知: "+name+", 参数列表："+ Arrays.toString(args));
    }


    @AfterReturning(value = "execution(public int com.zhang.aop.annoaop.CalculatorImp.add(..))",returning = "result") // 运行后通知最大的不同就是可以拿到返回值，别名需要和方法的参数一致
    public void afterReturningMethod(JoinPoint joinPoint,int result){
        String name = joinPoint.getSignature().getName();
        System.out.println("返回通知    "+name+"    "+result);

    }

    @AfterThrowing(value = "execution(public int com.zhang.aop.annoaop.CalculatorImp.div(..))",throwing = "ex")
    public void aftererror(Throwable ex){
        System.out.println("异常通知error"+ex.toString());  //有错就运行

    }


    @Around(value = "execution(public int com.zhang.aop.annoaop.CalculatorImp.div(..))")
    public Object around(ProceedingJoinPoint point){
        Object proceed = null;
        int i = 0;

        try {
            System.out.println("start   "+Arrays.toString(point.getArgs()));
             proceed = point.proceed();
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
