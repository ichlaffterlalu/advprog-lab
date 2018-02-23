package id.ac.ui.cs.advprog.tutorial2.exercise1.command;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class MacroCommand implements Command {

    private List<Command> commands;

    public MacroCommand(Command[] commands) {
        this.commands = Arrays.asList(commands);
    }

    @Override
    public void execute() {
        // TODO Complete me!
        for (int i = 0; i < commands.size(); i++) {
            commands.get(i).execute();
        }
    }

    @Override
    public void undo() {
        // TODO Complete me!
        for (int i = commands.size(); i >= 0; i++) {
            commands.get(i).undo();
        }
    }
}
