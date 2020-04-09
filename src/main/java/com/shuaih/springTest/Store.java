package com.shuaih.springTest;

import java.util.List;

public class Store {

    String store;
    List<String> products;
    Store(String  name, List<String> products) {
        this.store = name;
        this.products = products;
    }

    @Override
    public  String toString() {
        return store + " " + products;
    }
}
