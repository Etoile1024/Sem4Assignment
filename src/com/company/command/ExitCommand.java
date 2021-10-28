package com.company.command;

public class ExitCommand implements Command {
    public void execute() {
        System.out.println("Exit...");
        System.exit(0);
    }

    public void undo() {

    }
}
