package com.shuaih.springTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Profile {

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private String firstName;
    private String lastName;
    private int age;

    Profile(String first, String last, int age) {
        this.firstName = first;
        this.lastName = last;
        this.age = age;
    }


    public String toString(){
        return firstName + ","+ lastName + " age:" + age;
    }



}
