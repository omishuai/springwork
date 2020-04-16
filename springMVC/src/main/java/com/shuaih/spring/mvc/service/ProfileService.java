package com.shuaih.spring.mvc.service;

import com.shuaih.spring.mvc.db.Connector;
import com.shuaih.spring.mvc.db.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProfileService {


    private Connector conn;


    public Connector getConn() {
        return conn;
    }

    @Autowired
    public void setConn(Connector conn) {
        this.conn = conn;
    }




    // this will directly get controller the data
    public List<Profile> getCurrent() {

        // need to get conenctor to get data
        // get through autowired
        return conn.getProfiles();
    }

    ProfileService() {
        System.out.println("Service Started");
    }
}
