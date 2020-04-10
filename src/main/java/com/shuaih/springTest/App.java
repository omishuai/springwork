package com.shuaih.springTest;

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

        ((ClassPathXmlApplicationContext) context).close(); // ApplicationContext does not have close()
    }
}
