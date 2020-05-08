package org.wayne.spring.javase.contextclassload;

import org.wayne.spring.javase.DiskClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ContextClassLoaderTest {
    public static void main(String[] args) {

        DiskClassLoader1 diskClassLoader1 = new DiskClassLoader1("D:\\lib\\org");
        Class cls1 = null;

        try {
            cls1 = diskClassLoader1.loadClass("org.SpeakTest");
            System.out.println(cls1.getClassLoader().toString());
            if (cls1 != null) {
                Object obj = cls1.newInstance();
                Method method = cls1.getDeclaredMethod("speak", null);
                method.invoke(obj);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\lib");
        System.out.println("Thread "+ Thread.currentThread().getName() + " classloader:"+ Thread.currentThread().getContextClassLoader().toString());

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread "+Thread.currentThread().getName()+" classloader: "+Thread.currentThread().getContextClassLoader().toString());

                // TODO Auto-generated method stub
                try {
                    //加载class文件
                    Thread.currentThread().setContextClassLoader(diskClassLoader);
                    //Class c = diskLoader.loadClass("com.frank.test.SpeakTest");
                    ClassLoader cl = Thread.currentThread().getContextClassLoader();
                    Class c = cl.loadClass("org.SpeakTest");
                    // Class c = Class.forName("com.frank.test.SpeakTest");
                    System.out.println(c.getClassLoader().toString());
                    if(c != null){
                        try {
                            Object obj = c.newInstance();
                            //SpeakTest1 speak = (SpeakTest1) obj;
                            //speak.speak();
                            Method method = c.getDeclaredMethod("speak",null);
                            //通过反射调用Test类的say方法
                            method.invoke(obj, null);
                        } catch (InstantiationException | IllegalAccessException
                                | NoSuchMethodException
                                | SecurityException |
                                IllegalArgumentException |
                                InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
