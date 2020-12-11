package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 是线程之间相互等待，等到齐了之后一起继续；
 * CountDownLatch 是计数器，等待其他线程调用完了，一个或多个等待点继续向后进行
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        final int threadNum = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<threadNum * 2; i++) {
            executorService.execute(() -> {
                System.out.print("before..");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.print("after..");

            });
        }

        executorService.shutdown();

    }

}
