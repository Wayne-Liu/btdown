package org.wayne.spring.javase.designpattern.strategy;

/**
 * 策略模式： 定义一系列的算法，把他们封装起来，并且使他们可以互相替换
 */

public class StrategyDemo {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultipy());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
