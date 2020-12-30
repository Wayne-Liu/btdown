package org.wayne.spring.javase.designpattern.command;

public class Invoker {

    private Command[] onCommands;
    private Command[] offCommands;
    private final int slotNum = 7;

    public Invoker() {
        this.onCommands = new Command[slotNum];
        this.offCommands = new Command[slotNum];
    }

    public void setOnCommands(Command onCommands, int slot) {
        this.onCommands[slot] = onCommands;
    }

    public void setOffCommands(Command offCommands, int slot) {
        this.offCommands[slot] = offCommands;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

}
