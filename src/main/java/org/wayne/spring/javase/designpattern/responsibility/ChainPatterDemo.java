package org.wayne.spring.javase.designpattern.responsibility;

/**
 * 责任链模式：将对象连成一条链，并沿着这条链发送该请求，这样避免请求的发送者和接收者之间的耦合
 * 责任链模式需要一个抽象类定义抽象方法，具体类实现抽象方法来做某一动作，
 * 抽象类根据具体实现类的条件判断链上的实现类是否需要执行这个动作，
 * 链条关系由调用者实现调用关系
 */
public class ChainPatterDemo {

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "information");

        loggerChain.logMessage(AbstractLogger.DEBUG, "debug information");

        loggerChain.logMessage(AbstractLogger.ERROR, "error information");
    }
}
