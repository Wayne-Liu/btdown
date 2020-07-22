package org.wayne.spring.javase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class MyProxyTest {

    public static void main(String[] args)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        IHello iHello = (IHello) constructor.newInstance(new MyInvocationHandler(new HelloImpl()));
        iHello.sayHello();

        IHello iHello2 = (IHello)Proxy.newProxyInstance(IHello.class.getClassLoader(),
            new Class[]{IHello.class},
            new MyInvocationHandler(new HelloImpl()));
        iHello2.sayHello();
}
}
