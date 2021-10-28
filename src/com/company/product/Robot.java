package com.company.product;

public class Robot extends ToyProduct {
    private double height;

    public Robot(int productID, String name, double height) {
        super(productID, name);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        String result = "ID: " + getProductID() + "\r\nName: " + getName() + "\r\nQuantity: " + getQty() + "\r\nHeight(cm): " + getHeight() + "\r\nCost($): " + getCost() + "\r\nPrice($): " + getPrice();
        return result;
    }
}
