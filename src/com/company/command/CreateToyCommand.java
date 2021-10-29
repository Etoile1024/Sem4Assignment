package com.company.command;

import com.company.exception.UnknownToyTypeException;
import com.company.factory.ToyProductFactory;
import com.company.product.*;
import com.company.singleton.CommandsSingleton;
import com.company.singleton.ProductsSingleton;
import com.company.singleton.ScannerSingleton;

import java.util.Scanner;

public class CreateToyCommand implements Command {
    private ToyProduct toyProduct;

    public void execute() {
        Scanner scanner = ScannerSingleton.getInstance().getScanner();
        System.out.println("Enter toy type (ro=Robot/rc=Remote Control Car):");
        String toyType = scanner.nextLine();

        createToyByType(toyType);
    }

    public void undo() {
        if (ProductsSingleton.getInstance().contains(toyProduct))
            ProductsSingleton.getInstance().removeProduct(toyProduct);
        else
            ProductsSingleton.getInstance().addProduct(toyProduct);
    }

    private void createToyByType(String toyType) {
        ToyProductFactory toyFactory = new ToyProductFactory();
        try {
            toyProduct = toyFactory.getToyProduct(toyType);
            ProductsSingleton.getInstance().addProduct(toyProduct);
            CommandsSingleton.getInstance().pushUndoStack(this);
            System.out.println("New toy product record created.");
            System.out.println();
        } catch (UnknownToyTypeException ex) {
          System.out.println("Unknown toy type, please input again!");
          execute();
        } catch (Exception ex) {
            System.out.println("Input error when create toy, please input again!");
            createToyByType(toyType);
        }
    }

    public String toString() {
        String result = "Create " + toyProduct.getProductID() + " " + toyProduct.getName();
        return result;
    }

}
