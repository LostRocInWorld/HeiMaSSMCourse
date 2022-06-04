package com.dustin.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Classname MyAspect
 * @Descrption TODO
 * @Date 2021/8/1上午 01:32
 * @Created By Dustin_Peng
 */
public class MyAspect {
    public void before(){
        System.out.println("1.前置增强");
    }

    public void afterReturning(){
        System.out.println("6.后置增强");
    }

    /**
     * TODO 环绕通知
     * @param proceedingJoinPoint 正在执行的连接点-切点
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("2.环绕前...");
        //执行切点方法
        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("5.环绕后...");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("7.异常抛出增强...");
    }

    public void after(){
        System.out.println("4.最终通知增强...");
    }
}
