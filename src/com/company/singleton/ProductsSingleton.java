package com.company.singleton;

import com.company.product.ToyProduct;

import java.util.NoSuchElementException;
import java.util.Vector;

public class ProductsSingleton {
    private static ProductsSingleton productsSingleton;

    private Vector<ToyProduct> toyProductList;

    private ProductsSingleton() {
        toyProductList = new Vector<>();
    }

    public static ProductsSingleton getInstance() {
        if (productsSingleton == null)
            productsSingleton = new ProductsSingleton();
        return productsSingleton;
    }

    public ToyProduct getProductById(int productId) throws NoSuchElementException {
        return toyProductList.stream().filter((ToyProduct) -> ToyProduct.getProductID() == productId).findFirst().get();
    }

    public void addProduct(ToyProduct toyProduct) {
        toyProductList.add(toyProduct);
    }

    public void removeProduct(ToyProduct toyProduct) {
        toyProductList.remove(toyProduct);
    }

    public Vector<ToyProduct> getProductList() {
        return toyProductList;
    }

    public boolean contains(ToyProduct toyProduct) {
        return toyProductList.contains(toyProduct);
    }
}
