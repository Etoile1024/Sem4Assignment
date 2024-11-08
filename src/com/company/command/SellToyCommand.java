package com.company.command;

import com.company.memento.Memento;
import com.company.memento.SellToyMemento;
import com.company.product.ToyProduct;
import com.company.singleton.CommandsSingleton;
import com.company.singleton.ProductsSingleton;
import com.company.singleton.ScannerSingleton;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SellToyCommand implements Command {
    private ToyProduct toyProduct;
    private Memento toyMemento;

    private int id;
    private int qty;
    private double price;

    public void execute() {
        Scanner scanner = ScannerSingleton.getInstance().getScanner();
        String input = null;
        try {
            System.out.println("Enter code:");
            input = scanner.nextLine();
            id = Integer.parseInt(input);
            toyProduct = ProductsSingleton.getInstance().getProductById(id);

            System.out.println("Quantity to be sold:");
            input = scanner.nextLine();
            qty = Integer.parseInt(input);

            System.out.println("Selling price:");
            input = scanner.nextLine();
            price = Double.parseDouble(input);

            if (toyProduct.getQty() < qty) {
                System.out.println("Invalid quantity (current quantity < selling quantity).");
                System.out.println();
            } else {
                toyMemento = new SellToyMemento(toyProduct);

                toyProduct.setQty(toyProduct.getQty() - qty);
                toyProduct.setPrice(price);

                System.out.println("Sold " + qty + " boxes of " + toyProduct.getName() + ". Current quantity is " + toyProduct.getQty() + ". Selling price is $" + price + ".");
                System.out.println();

                CommandsSingleton.getInstance().pushUndoStack(this);
            }


        } catch (NoSuchElementException ex) {
            System.out.println("Can't find product, please input again!");
            execute();
        } catch(NumberFormatException ex) {
            System.out.println("Invalid input, please input again!");
            execute();
        }
    }

    public void undo() {
        var newMemento = new SellToyMemento(toyProduct);
        toyMemento.restore();
        toyMemento = newMemento;
    }

    public String toString() {
        String result = "Sell " + qty + " " + id + " " + toyProduct.getName() + " " + price;
        return result;
    }
}
