package com.dustin.proxy.cligb;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.beans.EventHandler;
import java.lang.reflect.Method;

/**
 * @Classname ProxyTest
 * @Descrption TODO
 * @Date 2021/7/31下午 10:29
 * @Created By Dustin_Peng
 */
public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        Target target = new Target();

        //创建增强对象
        Advice advice = new Advice();

        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3.设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //执行前置方法
                advice.before();
                //执行目标方法
                Object result = method.invoke(target, args);
                //执行后置方法
                advice.after();
                return result;
            }
        });
        //4.创建代理对象
        Target targetProxy = (Target) enhancer.create();

        //5.测试
        targetProxy.save();
    }
}
