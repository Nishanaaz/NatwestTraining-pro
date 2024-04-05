package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            //Step 1- load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class found");

            //Step-2 establish the connection.
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","nisha786");
            System.out.println("Connected successfully");

            //Step 3 create the statement and prepare statement object
            Statement statement = connection.createStatement();
            statement.execute("insert into employees values(67,'Jainab','hr',53322,2045,null)");
            ResultSet rs = statement.executeQuery("select * from employees");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            }
            System.out.println("inserted");
            connection.close();


        }
        catch (Exception e){
            e.printStackTrace();  //it will print the errror
            System.out.println(e.getMessage());
        }
    }
}