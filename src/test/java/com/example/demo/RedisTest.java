package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wayne.redis.HelloService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    HelloService helloService;

    @Test
    public void test1() {
        helloService.hello();
    }

    @Test
    public void test2() {
        helloService.hello2();
    }
}
