package com.company.command;

import com.company.exception.UnknownToyTypeException;
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
        try {
            toyProduct = createToyProduct(toyType);
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

    public ToyProduct createToyProduct(String toyType) throws UnknownToyTypeException {
        Scanner scanner = ScannerSingleton.getInstance().getScanner();
        String input;
        int id;
        String name;

        switch (toyType) {
            case "ro":
                System.out.println("Enter id:");
                input = scanner.nextLine();
                id = Integer.parseInt(input);

                System.out.println("Enter name:");
                input = scanner.nextLine();
                name = input;

                System.out.println("Enter height(cm):");
                input = scanner.nextLine();
                double height = Double.parseDouble(input);

                return new Robot(id, name, height);
            case "rc":
                System.out.println("Enter id:");
                input = scanner.nextLine();
                id = Integer.parseInt(input);

                System.out.println("Enter name:");
                input = scanner.nextLine();
                name = input;

                System.out.println("Enter maximum speed(km/hr):");
                input = scanner.nextLine();
                double maxSpeed = Double.parseDouble(input);

                return new RemoteControlCar(id, name, maxSpeed);
            default:
                throw new UnknownToyTypeException();
        }
    }

    public String toString() {
        String result = "Create " + toyProduct.getProductID() + " " + toyProduct.getName();
        return result;
    }

}
