package com.company.command;

import com.company.product.*;

import java.util.Scanner;

public class CreateToyCommand implements Command {
    private ToyProduct toyProduct;

    public void execute() {
        recvToyType();
    }

    public void undo() {
        if (Products.contains(toyProduct))
            Products.removeProduct(toyProduct);
        else
            Products.addProduct(toyProduct);
    }

    private void recvToyType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter toy type (ro=Robot/rc=Remote Control Car):");
        String toyType = scanner.nextLine();
        createToyByType(toyType);
    }

    private void createToyByType(String toyType) {
        try {
            Scanner scanner = new Scanner(System.in);
            String input;
            int id;
            String name;
            switch (toyType) {
                case "ro":
                    System.out.println("Enter id, name and height(cm):");
                    input = scanner.nextLine();

                    id = Integer.parseInt(input.split(",")[0]);
                    name = input.split(",")[1];
                    double height = Double.parseDouble(input.split(",")[2]);

                    toyProduct = new Robot(id, name, height);
                    Products.addProduct(toyProduct);
                    break;
                case "rc":
                    System.out.println("Enter id, name and maximum speed(km/hr):");
                    input = scanner.nextLine();

                    id = Integer.parseInt(input.split(",")[0]);
                    name = input.split(",")[1];
                    double maxSpeed = Double.parseDouble(input.split(",")[2]);

                    toyProduct = new RemoteControlCar(id, name, maxSpeed);
                    Products.addProduct(toyProduct);
                    break;
                default:
                    System.out.println("Invalid toy type, please input again!");
                    recvToyType();
                    break;
            }
            CommandStacks.pushUndoStack(this);
            System.out.println("New toy product record created.");
            System.out.println();
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
