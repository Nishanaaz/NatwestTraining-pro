package org.example;

import org.example.ex.Restaurant;
import org.example.task.ConnectionDb;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("objects.xml");
        Employee employee = (Employee) applicationContext.getBean("emp");
        employee.setName("Nisha");
        System.out.println(employee.getName());

        Restaurant restaurant = (Restaurant)applicationContext.getBean("res2");
//        Restaurant restaurant1 = (Restaurant) applicationContext.getBean("res2");
        System.out.println(restaurant.getName());
        System.out.println(restaurant.getAddress());

        Restaurant restaurant1 =(Restaurant) applicationContext.getBean("res3");
        System.out.println(restaurant.getAddress());
        System.out.println(restaurant.getName());

//        ConnectionDb connectionDb = (ConnectionDb) applicationContext.getBean("db");
//        connectionDb.setDbName("Oracle");
//        System.out.println(connectionDb.getDbName());
//

    }
}