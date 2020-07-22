package org.wayne.spring.javase.reflect.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clz = Class.forName("org.wayne.spring.javase.reflect.invoke.TestClassLoad");
        Object o = clz.newInstance();
        Method m = clz.getMethod("test", String.class, Integer.class);
        for (int i = 0; i < 6; i++) {
            m.invoke(o, "Wayne", i);
        }

        Class<?> clz2 = Class.forName("org.wayne.spring.javase.reflect.invoke.TestClassLoad2");
        Object o2 = clz2.newInstance();
        Method m2 = clz2.getMethod("test", String.class, Integer.class);
        for (int i = 0; i < 6; i++) {
            m.invoke(o, "Wayne2", i);
        }

        for (int i = 0; i < 6; i++) {
            m.invoke(o, "Wayne", i);
        }
    }
}

class TestClassLoad {
    public void test(String s, Integer i) {
        System.out.println(s + ":测试： " + i);
    }
}

class TestClassLoad2 {
    public void test(String s, Integer i) {
        System.out.println(s + ":测试： " + i);
    }
}