package com.company.command;

import com.company.memento.Memento;
import com.company.memento.PurchaseToyMemento;
import com.company.product.Products;
import com.company.product.ToyProduct;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PurchaseToyCommand implements Command {
    private ToyProduct toyProduct;
    private Memento toyMemento;
    private int id;
    private int qty;
    private double cost;

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        try {
            System.out.println("Enter code:");
            input = scanner.nextLine();
            id = Integer.parseInt(input);
            toyProduct = Products.getProductById(id);

            System.out.println("Quantity to be purchased:");
            input = scanner.nextLine();
            qty = Integer.parseInt(input);

            System.out.println("Purchasing cost:");
            input = scanner.nextLine();
            cost = Double.parseDouble(input);

            toyMemento = new PurchaseToyMemento(toyProduct);

            toyProduct.setQty(toyProduct.getQty() + qty);
            toyProduct.setCost(cost);

            System.out.println("Purchased " + qty + " boxes of " + toyProduct.getName() + ". Current quantity is " + toyProduct.getQty() + ". Current cost is $" + toyProduct.getCost() + ". Price is $" + toyProduct.getPrice() + ".");
            System.out.println();

            CommandStacks.pushUndoStack(this);

        } catch (NoSuchElementException ex) {
            System.out.println("Can't find product, please input again!");
            execute();
        } catch(NumberFormatException ex) {
            System.out.println("Invalid input, please input again!");
            execute();
        }
    }

    public void undo() {
        var newMemento = new PurchaseToyMemento(toyProduct);
        toyMemento.restore();
        toyMemento = newMemento;
    }

    public String toString() {
        String result = "Purchase " + qty + " " + id + " " + toyProduct.getName() + " " + cost;
        return result;
    }
}
