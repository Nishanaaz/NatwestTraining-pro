package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public DbConnection getInstanceOfDbConnection(){
        DbConnection dbConnection = new DbConnection();
        dbConnection.setUserName("user1");
        dbConnection.setPassword("pass1");
        return dbConnection;
    }
    @Bean
    public DbConnection getInstance2(){
        return new DbConnection("user1","pass2");
    }
}
