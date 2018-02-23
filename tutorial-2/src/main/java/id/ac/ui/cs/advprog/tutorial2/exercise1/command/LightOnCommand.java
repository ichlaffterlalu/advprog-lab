package id.ac.ui.cs.advprog.tutorial2.exercise1.command;

import id.ac.ui.cs.advprog.tutorial2.exercise1.receiver.Light;

public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        // TODO Complete me!
        light.on();
    }

    @Override
    public void undo() {
        // TODO Complete me!
        light.off();
    }
}
