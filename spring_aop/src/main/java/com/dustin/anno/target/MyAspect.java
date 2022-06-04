package com.dustin.anno.target;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Classname MyAspect
 * @Descrption TODO
 * @Date 2021/8/1上午 01:32
 * @Created By Dustin_Peng
 */
@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {
    //定义一个切点表达式
    @Pointcut("execution(public void com.dustin.anno.target.Target.save(..))")
    public void myPoint(){
    }

    //配置前置通知
    @Before(value = "myPoint()")
    public void before(){
        System.out.println("前置增强");
    }

    public void afterReturning(){
        System.out.println("后置增强");
    }

    /**
     * TODO 环绕通知
     * @param proceedingJoinPoint 正在执行的连接点-切点
     * @throws Throwable
     */
    @Around(value = "MyAspect.myPoint()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前...");
        //执行切点方法
        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("环绕后...");
        return proceed;
    }

    @AfterThrowing(value = "execution(public void com.dustin.anno.target.Target.save(..))")
    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }

    public void after(){
        System.out.println("最终通知增强...");
    }
}
