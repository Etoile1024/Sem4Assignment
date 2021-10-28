package com.company.command;

import java.util.Stack;

public class CommandStacks {
    private static Stack<Command> undoStack = new Stack<>();

    private static Stack<Command> redoStack = new Stack<>();

    public static void pushUndoStack(Command cmd) {
        undoStack.push(cmd);
    }

    public static void pushRedoStack(Command cmd) {
        redoStack.push(cmd);
    }

    public static Stack<Command> getUndoStack() {
        return undoStack;
    }

    public static Stack<Command> getRedoStack() {
        return redoStack;
    }
}
