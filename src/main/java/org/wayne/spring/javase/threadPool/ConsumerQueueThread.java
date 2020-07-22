package org.wayne.spring.javase.threadPool;

public class ConsumerQueueThread implements Runnable {
    @Override
    public void run() {
        System.out.println("当前线程为：" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
