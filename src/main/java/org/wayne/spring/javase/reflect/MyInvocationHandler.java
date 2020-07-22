package org.wayne.spring.javase.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------插入前置通知代码----------");
        Object rs = method.invoke(target, args);
        System.out.println("-------插入后置处理代码----------");
        return rs;
    }
}
