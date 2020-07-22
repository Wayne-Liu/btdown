package org.wayne.spring.javase.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock称为可重入锁，下面是应用场景：
 * 1、如果发现操作已经在执行中，则不再执行，例如定时任务时，任务执行时间超过下次计划执行时间，使用lock.tryLock();
 * 2、如果发现该操作已经在执行，等待一个一个执行，类似synchronized,不过分为公平锁和非公平锁
 * 3、如果发现操作在执行，等一段时间，等超时则不执行lock.tryLock(5,TimeUnit.SECONDS)
 * 4、发现操作在执行，可以中断正在进行的操作释放锁继续下一操作。lock.lockInterruptibly()
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():" + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS):" + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        Thread.sleep(200);
        new Thread() {
            {
                setDaemon(true);
            }

            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.sleep(200);
        al.untimed();
        al.timed();
    }
}
