package com.shuaih.springTest;

import org.springframework.beans.factory.annotation.Autowired;

public class Connector {

    private String user;
    private String password;

    public void setUser(String str) {
        user = str;
    }
    public void setPassword(String pass) {
        password = pass;
    }

    public void init(){
        System.out.println(user + ": " + password);
    }
}
