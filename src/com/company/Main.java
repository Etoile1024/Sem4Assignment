package com.company;

import com.company.command.*;
import com.company.exception.UnknownCommandException;
import com.company.singleton.ScannerSingleton;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = ScannerSingleton.getInstance().getScanner();
        while (true) {
            help();
            try {
                String input = scanner.nextLine();
                Command cmd = createCommand(input);
                cmd.execute();
            } catch (UnknownCommandException ex) {
                System.out.println("Invalid command!");
                System.out.println();
            }

        }

    }

    public static Command createCommand(String input) throws UnknownCommandException {
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

    public static void help() {
        System.out.println("Toy Inventory Management System (TIMS)");
        System.out.println("Please enter command: [c | d | p | s | u | r | l | x]");
        System.out.println("c = create toy, d = display toy, p = purchase toy, s = sell toy, ");
        System.out.println("u = undo, r = redo, l = list undo/redo, x = exit system");
        System.out.println();
    }
}
