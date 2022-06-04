package com.dustin.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname ProxyTest
 * @Descrption TODO
 * @Date 2021/7/31下午 10:11
 * @Created By Dustin_Peng
 */
public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        Target target = new Target();

        //创建增强对象
        Advice advice = new Advice();

        //返回动态生成的代理对象，Proxy的API
        TargetInterface proxyTarget = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象的类加载器
                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象
                new InvocationHandler() {
                    @Override
                    //调用代理对象的任何方法 实质执行的都是invoke方法
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        //前置增强
                        advice.before();
                        //执行目标方法target.save
                        Object result = method.invoke(target, objects);
                        //后置增强
                        advice.after();

                        return result;
                    }
                }
        );

        //调用代理对象的方法
        proxyTarget.save();
    }
}
