package com.company.command;

import com.company.product.RemoteControlCar;
import com.company.product.Robot;
import com.company.product.ToyProduct;
import com.company.singleton.ProductsSingleton;
import com.company.singleton.ScannerSingleton;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DisplayToyCommand implements Command {
    public void execute() {
        Scanner scanner = ScannerSingleton.getInstance().getScanner();
        System.out.println("Enter ID (* to display all):");
        String input = scanner.nextLine();
        if (input.equals("*")) {
            System.out.println("Toy product information");
            System.out.println("ID  Name    Quantity    Other Info    Cost    Price");
            for (var toyProduct : ProductsSingleton.getInstance().getProductList()) {
                int id = toyProduct.getProductID();
                String name = toyProduct.getName();
                int qty = toyProduct.getQty();
                String otherInfo = null;
                if (toyProduct instanceof Robot)
                    otherInfo = ((Robot)toyProduct).getHeight() + "cm";
                if (toyProduct instanceof RemoteControlCar)
                    otherInfo = ((RemoteControlCar)toyProduct).getMaxSpeed() + "km/hr";
                double cost = toyProduct.getCost();
                double price = toyProduct.getPrice();
                System.out.println(id + "   " + name + "  " + qty + "   " + otherInfo + "   " + cost + "    " + price);
            }
            System.out.println();
        } else {
            try {
                var toyProduct = ProductsSingleton.getInstance().getProductById(Integer.parseInt(input));
                System.out.println("Toy product information");
                System.out.println(toyProduct);
                System.out.println();
            } catch (NoSuchElementException ex) {
                System.out.println("Can't find product! Please input again!");
                execute();
            } catch (NumberFormatException ex) {
                System.out.println("Input error, please input again!");
                execute();
            }

        }
    }

    public void undo() {

    }
}
