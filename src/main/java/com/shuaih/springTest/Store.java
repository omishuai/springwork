package com.shuaih.springTest;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Store {

    String store;
    List<String> products;

    @Autowired (required=false)
    private Client client;

    @Autowired
    private Factory supply;

    Store(String  name, List<String> products) {
        this.store = name;
        this.products = products;
    }

    void requestSupplier() {
        System.out.println(supply);
    }
    void requestClient() {
        if (client  == null) {
            System.out.println("Client is not created");
            return;
        }
        System.out.println(client);
    }
    public void init(){
        System.out.println(this + " is created");
    }

    @Override
    public  String toString() {
        return store + " " + products;
    }
}
