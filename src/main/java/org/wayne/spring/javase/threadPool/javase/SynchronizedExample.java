package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {
    public void func1() {
        synchronized (SynchronizedExample.class) {
            for (int i=0;i<10;i++) {
                System.out.print(i+" ");
            }
        }
    }

//    public static void main(String[] args) {
//        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
//    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        System.out.println(e1 == e2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());

        executorService.shutdown();
    }
}
