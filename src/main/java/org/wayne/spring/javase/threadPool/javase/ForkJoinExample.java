package org.wayne.spring.javase.threadPool.javase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {

    private final int threadHold = 5;
    private int first;
    private int last;

    public ForkJoinExample(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first <= threadHold) {
            for (int i=first; i <= last; i++) {
                result +=i;
            }
        } else {
            int mid = (last - first) / 2 + first;
            ForkJoinExample leftTask = new ForkJoinExample(first, mid);
            ForkJoinExample rightTask = new ForkJoinExample(mid + 1, last);
            leftTask.fork();
            rightTask.fork();

            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample forkJoinExample = new ForkJoinExample(1,10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(forkJoinExample);
        System.out.println(result.get());
    }

}
