package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<totalThread;i++) {
            executorService.execute(() -> {
                System.out.print("run. ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.print("end.!");

        executorService.shutdown();
    }
}
