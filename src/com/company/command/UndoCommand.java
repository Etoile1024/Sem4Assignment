package com.company.command;

public class UndoCommand implements Command {
    public void execute() {
        var undoStack = CommandStacks.getUndoStack();
        if(!undoStack.isEmpty()) {
            var cmd = undoStack.pop();
            cmd.undo();
            CommandStacks.pushRedoStack(cmd);
            System.out.println("Undo completed.");
        } else
            System.out.println("Nothing to undo!");
        System.out.println();
    }

    public void undo() {

    }
}
