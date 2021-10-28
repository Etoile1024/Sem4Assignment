package com.company;

import com.company.command.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        while (true) {
            help();
            String input = scanner.nextLine();
            boolean recvCmd = true;
            Command cmd = null;
            switch (input) {
                default:
                    System.out.println("Incorrect command!");
                    recvCmd = false;
                    break;
                case "c":
                    cmd = new CreateToyCommand();
                    break;
                case "d":
                    cmd = new DisplayToyCommand();
                    break;
                case "p":
                    cmd = new PurchaseToyCommand();
                    break;
                case "s":
                    cmd = new SellToyCommand();
                    break;
                case "l":
                    cmd = new DisplayStackCommand();
                    break;
                case "u":
                    cmd = new UndoCommand();
                    break;
                case "r":
                    cmd = new RedoCommand();
                    break;
                case "x":
                    cmd = new ExitCommand();
                    break;

            }
            if (recvCmd)
                cmd.execute();
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
