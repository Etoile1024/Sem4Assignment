package com.company.command;

import com.company.singleton.CommandsSingleton;

import java.util.EmptyStackException;

public class UndoCommand implements Command {
    public void execute() {
        try {
            CommandsSingleton.getInstance().executeUndo();
            System.out.println("Undo completed.");
        } catch (EmptyStackException ex) {
            System.out.println("Nothing to undo.");
        } finally {
            System.out.println();
        }
    }

    public void undo() {

    }
}
