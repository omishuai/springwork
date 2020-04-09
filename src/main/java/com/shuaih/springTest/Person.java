package com.shuaih.springTest;


public class Person {
    String name;
    int id;
    private int taxId;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Person(){}
    void speak() {
        System.out.println("I am speaking");
    }


    @Override
    public String toString() {
        return id + " " + name + " " +taxId ;
    }

    public  void setTaxId(int id) {
        taxId = id;
    }

//    int getTaxId(){
//        return taxId;
//    }

}