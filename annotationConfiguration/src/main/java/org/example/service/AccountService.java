package org.example.service;

import org.example.dataAccessObject.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AccountService {
    @Autowired
    AccountDao accountDao;
    public void createAccount(){
        System.out.println("business logic");
    }
}
