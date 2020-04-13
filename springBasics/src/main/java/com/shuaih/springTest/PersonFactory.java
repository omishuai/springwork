package com.shuaih.springTest;

public class PersonFactory {
    public Person createPerson(int id, String name) {
        System.out.println("Creating person in Factory class");
        return  new Person(id, name);
    }
}
