package com.company;

import com.company.command.*;
import com.company.exception.UnknownCommandException;
import com.company.factory.CommandFactory;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        CommandFactory cmdFactory = new CommandFactory();
        while (true) {
            help();
            try {
                String input = scanner.nextLine();
                Command cmd = cmdFactory.getCommand(input);
                cmd.execute();
            } catch (UnknownCommandException ex) {
                System.out.println("Invalid command!");
                System.out.println();
            }

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
