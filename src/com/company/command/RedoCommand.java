package com.company.command;

import com.company.singleton.CommandsSingleton;

import java.util.EmptyStackException;

public class RedoCommand implements Command {
    public void execute() {
        try {
            CommandsSingleton.getInstance().executeRedo();
            System.out.println("Redo completed.");
        } catch (EmptyStackException ex) {
            System.out.println("Nothing to redo.");
        } finally {
            System.out.println();
        }
    }

    public void undo() {

    }
}
