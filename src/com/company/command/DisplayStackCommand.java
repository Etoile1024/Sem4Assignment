package com.company.command;

public class DisplayStackCommand implements Command {
    public void execute() {
        System.out.println();
        System.out.println("Undo List:");
        var undoStack = CommandStacks.getUndoStack();
        if(undoStack.isEmpty())
            System.out.println("Empty");
        else {
            for (var cmd : undoStack)
                System.out.println(cmd);
        }

        System.out.println();
        System.out.println("Redo List:");
        var redoStack = CommandStacks.getRedoStack();
        if(redoStack.isEmpty())
            System.out.println("Empty");
        else {
            for (var cmd : redoStack)
                System.out.println(cmd);
        }

        System.out.println();
    }

    public void undo() {

    }
}
