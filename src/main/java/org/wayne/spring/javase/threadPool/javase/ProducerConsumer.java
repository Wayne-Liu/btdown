package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class ProducerConsumer {

    static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("producer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("product..");
        }
    }

    public static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("consume..");
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<2;i++) {
            Producer producer = new Producer();
            producer.start();
        }

        for (int i=0; i<5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for(int i=0;i<3;i++) {
            Producer producer = new Producer();
            producer.start();
        }

    }

}
