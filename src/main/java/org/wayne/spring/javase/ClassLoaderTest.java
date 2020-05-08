package org.wayne.spring.javase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {

    public static void main(String[] args) {
        //System.out.println(System.getProperty("sun.boot.class.path"));

        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
        //System.out.println("ClassLoader is:"+cl.toString());
        //System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());

        cl = int.class.getClassLoader();

        //System.out.println("int ClassLoader:"+cl.toString());


        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\lib");

        try {
            Class c = diskClassLoader.loadClass("org.Test");
            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    Method method = c.getMethod("say",null);
                    method.invoke(obj, null);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


//          FileUtils.decodeFile("D:\\lib\\Test.class");

//        DecodeClassLoader decodeClassLoader = new DecodeClassLoader("D:\\lib");
//
//        try {
//            Class c = decodeClassLoader.loadClass("org.Test");
//            if (c != null) {
//                try {
//                    Object obj = c.newInstance();
//                    Method method = c.getMethod("say",null);
//                    method.invoke(obj, null);
//
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}
