package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        DbConnection dbConnection = (DbConnection) context.getBean("getInstance2");
        dbConnection.setUserName("Nisha");
        dbConnection.setPassword("5467");
        System.out.println(dbConnection.getUserName());
        System.out.println(dbConnection.getPassword());
    }
}