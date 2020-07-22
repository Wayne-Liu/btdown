package com.example.demo.spring.javase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wayne.spring.javase.threadPool.ConsumerQueueThread;

import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolTests {

    //@Resource(name = "consumerQueueThreadPool")
    @Autowired
    private ExecutorService consumerQueueThreadPool;

    @Test
    public void execute1() {
        for (int i=0; i<10; i++) {
            consumerQueueThreadPool.execute(new ConsumerQueueThread());
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void test1() {
//        ThreadPoolTests test = new ThreadPoolTests();
//        test.execute();
//    }

}
