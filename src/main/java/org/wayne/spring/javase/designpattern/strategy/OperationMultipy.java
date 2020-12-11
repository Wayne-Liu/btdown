package org.wayne.spring.javase.designpattern.strategy;

public class OperationMultipy implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
