package com.shuaih.springTest;

import java.util.*;

import jdk.nashorn.internal.runtime.ECMAException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");  //bean container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");  //bean container
        // src/main/resources is always on the classpath
//        Person p1 = (Person) context.getBean("person");
//        p1.speak();
//
//        Person p2 = (Person) context.getBean("person");
//        p2.setTaxId(100);
//
//
//        System.out.println(p1);
//        System.out.println(p2);
//
//        Store store = (Store) context.getBean("store");
//        System.out.println(store);
//        store.requestClient();
//        store.requestSupplier();

        Connector dbc = (Connector) context.getBean("connector");
        try {
//            dbc.createTale();
            List<Profile> profiles = new ArrayList<Profile>();

            Profile p1 = new Profile("Sta", "Baro", 20);
            Profile p2 = new Profile("St", "Bar", 40);
            Profile p3 = new Profile("S", "Ba", 43);
            Profile p4 = new Profile("A", "B", 27);
            profiles.add(p1);
            profiles.add(p2);
            profiles.add(p3);
            profiles.add(p4);

            int[] res =  dbc.addProfiles(profiles);
            for (int i : res)  System.out.println("Updated " + i + " rows");

            List<Profile> ls = dbc.getProfiles();
            for (Profile p : ls) System.out.println(p);

        }catch (Exception e) {
            e.printStackTrace();
        }
        ((ClassPathXmlApplicationContext) context).close(); // ApplicationContext does not have close()
    }
}
