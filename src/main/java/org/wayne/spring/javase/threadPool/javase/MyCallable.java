package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static javafx.util.Duration.seconds;
import static org.wayne.btdown.common.SleepUtils.sleep;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        sleep(2000);
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }

}
