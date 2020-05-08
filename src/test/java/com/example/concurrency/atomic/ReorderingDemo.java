package com.example.concurrency.atomic;

public class ReorderingDemo {

    static volatile int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 100000000000l; i++) {
            x=y=a=b=0;
            Thread one = new Thread() {
                public void run() {
                    a = 1;
                    x = b;
                }
            };
            Thread two = new Thread() {
                public void run() {
                    b = 1;
                    y = a;
                }
            };
            one.start();
            two.start();
            one.join();
            two.join();
            //if (x==0 && y==0) {
                System.out.println(x + " " + y);
            //}
        }
    }
}
