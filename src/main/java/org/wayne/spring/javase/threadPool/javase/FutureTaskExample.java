package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int count = 0;
                for (int i=0; i<100; i++) {
                    Thread.sleep(1000);
                    count += i;
                }
                return count;
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("second run ..");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        System.out.println("sum="+futureTask.get());
    }
}
