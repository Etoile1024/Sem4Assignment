package com.company.factory;

import com.company.command.*;
import com.company.exception.UnknownCommandException;

public class CommandFactory {
    public Command getCommand(String input) throws UnknownCommandException {
        switch (input) {
            default:
                throw new UnknownCommandException();
            case "c":
                return new CreateToyCommand();
            case "d":
                return new DisplayToyCommand();
            case "p":
                return new PurchaseToyCommand();
            case "s":
                return new SellToyCommand();
            case "l":
                return new DisplayStackCommand();
            case "u":
                return new UndoCommand();
            case "r":
                return new RedoCommand();
            case "x":
                return new ExitCommand();
        }
    }
}
