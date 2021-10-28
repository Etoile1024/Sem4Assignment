package com.company.memento;

import com.company.product.ToyProduct;

public class SellToyMemento implements Memento {
    private ToyProduct toyProduct;

    private int qty;
    private double price;

    public SellToyMemento(ToyProduct toyProduct) {
        this.toyProduct = toyProduct;
        this.qty = toyProduct.getQty();
        this.price = toyProduct.getPrice();
    }

    public void restore() {
        toyProduct.setQty(qty);
        toyProduct.setPrice(price);
    }
}
