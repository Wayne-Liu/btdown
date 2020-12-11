package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        int clientCount = 3;
        int threadCount = 10;

        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<threadCount; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();

                    System.out.print(semaphore.availablePermits()+" ");

                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            });
        }

        executorService.shutdown();
    }
}
