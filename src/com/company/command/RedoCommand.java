package com.company.command;

public class RedoCommand implements Command {
    public void execute() {
        var redoStack = CommandStacks.getRedoStack();
        if(!redoStack.isEmpty()) {
            var cmd = redoStack.pop();
            cmd.undo();
            CommandStacks.pushUndoStack(cmd);
            System.out.println("Redo completed.");
        } else
            System.out.println("Nothing to redo!");
        System.out.println();
    }

    public void undo() {

    }
}
