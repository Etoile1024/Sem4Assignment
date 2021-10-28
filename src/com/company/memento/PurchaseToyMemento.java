package com.company.memento;

import com.company.product.ToyProduct;

public class PurchaseToyMemento implements Memento {
    private ToyProduct toyProduct;
    private int qty;
    private double cost;

    public PurchaseToyMemento(ToyProduct toyProduct) {
        this.toyProduct = toyProduct;
        this.qty = toyProduct.getQty();
        this.cost = toyProduct.getCost();
    }

    public void restore() {
        toyProduct.setQty(qty);
        toyProduct.setCost(cost);
    }
}
