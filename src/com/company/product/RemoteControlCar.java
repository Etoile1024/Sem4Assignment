package com.company.product;

public class RemoteControlCar extends ToyProduct {
    private double maxSpeed;

    public RemoteControlCar(int productID, String name, double maxSpeed) {
        super(productID, name);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String toString() {
        String result = "ID: " + getProductID() + "\r\nName: " + getName() + "\r\nQuantity: " + getQty() + "\r\nMaximum Speed(km/hr): " + getMaxSpeed() + "\r\nCost($): " + getCost() + "\r\nPrice($): " + getPrice();
        return result;
    }
}
