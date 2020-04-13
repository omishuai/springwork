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
}
