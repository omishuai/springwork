package com.shuaih.springTest;


public class Person {
    String name;
    int id;
    private int taxId;
    Address street;

    Person(int id, String name) {
        this.id = id;
        this.name = name;

    }

//    public static Person createPerson(int id, String name) {
//        System.out.println("In creating person in Person class..");
//        return new Person(id, name);
//    }

    Person(){

    }
    void speak() {
        System.out.println("I am speaking");
    }


    @Override
    public String toString() {
        return id + " " + name + " " + taxId + " " +street ;
    }

    public  void setTaxId(int id) {
        taxId = id;
    }

    public void onCreate(){
        System.out.println("onCreate: " + this);
    }

    public void init(){
        System.out.println("init: " + this);
    }

    public void setStreet(Address street) {
        this.street = street;
    }

//    int getTaxId(){
//        return taxId;
//    }

}