package com.shuaih.springTest;

public class Address {
    String streetName;
    int zipcode;
    int sec;

    Address(String str, int code) {
        zipcode = code;
        streetName = str;
    }
    public void init () {
        System.out.println("init: " + this);
    }
    @Override
    public String toString() {
        return streetName + " " + zipcode;
    }


    void setSec(int number){
        sec = number;
    }
}

