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

        Person p = (Person) context.getBean("person");
        p.speak();
        System.out.println(p);

        ((ClassPathXmlApplicationContext) context).close(); // ApplicationContext does not have close()
    }
}
