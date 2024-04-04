package org.example.dataAccessObject;

import org.springframework.stereotype.Component;

@Component  //bean configuration

public class AccountDao {
    public void createAccount(){
        System.out.println("database logic");
    }
}
