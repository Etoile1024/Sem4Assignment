package com.company.product;

import java.util.*;

public class Products {
    private static Vector<ToyProduct> toyProductList = new Vector<>();

    public static ToyProduct getProductById(int productId) throws NoSuchElementException {
        return toyProductList.stream().filter((ToyProduct) -> ToyProduct.getProductID() == productId).findFirst().get();
    }

    public static void addProduct(ToyProduct toyProduct) {
        toyProductList.add(toyProduct);
    }

    public static void removeProduct(ToyProduct toyProduct) {
        toyProductList.remove(toyProduct);
    }

    public static Vector<ToyProduct> getProductList() {
        return toyProductList;
    }

    public static boolean contains(ToyProduct toyProduct) {
        return toyProductList.contains(toyProduct);
    }
}
