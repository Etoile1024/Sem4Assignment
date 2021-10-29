package com.company.singleton;

import com.company.command.Command;
import java.util.*;

public class CommandsSingleton {
    private static CommandsSingleton cmdSingleton;

    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    private CommandsSingleton() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static CommandsSingleton getInstance() {
        if (cmdSingleton == null)
            cmdSingleton = new CommandsSingleton();
        return cmdSingleton;
    }

    public void pushUndoStack(Command cmd) {
        undoStack.push(cmd);
    }

    public void pushRedoStack(Command cmd) {
        redoStack.push(cmd);
    }

    public Command popUndoStack() throws EmptyStackException {
        if (!undoStack.isEmpty())
            return undoStack.pop();
        else
            throw new EmptyStackException();
    }

    public Command popRedoStack() throws EmptyStackException {
        if(!redoStack.isEmpty())
            return redoStack.pop();
        else
            throw new EmptyStackException();
    }

    public void executeUndo() throws EmptyStackException {
        Command cmd = popUndoStack();
        cmd.undo();
        pushRedoStack(cmd);
    }

    public void executeRedo() throws EmptyStackException {
        Command cmd = popRedoStack();
        cmd.undo();
        pushUndoStack(cmd);
    }

    public Stack<Command> getUndoStack() {
        return undoStack;
    }

    public Stack<Command> getRedoStack() {
        return redoStack;
    }
}
