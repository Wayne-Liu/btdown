package org.wayne.spring.javase.lock;

import org.jboss.netty.util.internal.NonReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {

    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(5);

        System.out.println(ai.incrementAndGet());

        //NonReentrantLock
    }
}
