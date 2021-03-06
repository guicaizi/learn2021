package com.software.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactry<T> {
  private T target;

    public ProxyFactry(T target) {
        this.target = target;
    }
    public Object getProxyInstance(){
        System.out.println( "interface"+target.getClass().getInterfaces().getClass());
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                }
        );
    }
}
