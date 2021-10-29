package com.company.factory;

import com.company.exception.UnknownToyTypeException;
import com.company.product.RemoteControlCar;
import com.company.product.Robot;
import com.company.product.ToyProduct;
import com.company.singleton.ScannerSingleton;

import java.util.Scanner;

public class ToyProductFactory {
    public ToyProduct getToyProduct(String toyType) throws UnknownToyTypeException {
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
}
