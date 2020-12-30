package org.wayne.spring.javase.designpattern.command;

public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        invoker.setOnCommands(lightOnCommand, 1);
        invoker.setOffCommands(lightOffCommand, 2);

        invoker.onButtonWasPushed(1);
        invoker.offButtonWasPushed(2);

    }
}
