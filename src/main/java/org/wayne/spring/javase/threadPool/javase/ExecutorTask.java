package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTask {

    private static class MyRunnable implements Runnable {
        private int threadId;

        public MyRunnable(int id) {
            this.threadId = id;
        }
        @Override
        public void run() {
            System.out.println("运行到第"+threadId );
        }
    }

//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newCachedThreadPool();
//        for (int i=0;i<5;i++) {
//            executor.execute(new MyRunnable(i));
//        }
//        executor.shutdown();
//
//
//    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }
}
