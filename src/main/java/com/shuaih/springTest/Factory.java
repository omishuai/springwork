package com.shuaih.springTest;

public class Factory {

    private String name;


    Factory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void init() {
        System.out.println(name + " is Created");
    }
}
