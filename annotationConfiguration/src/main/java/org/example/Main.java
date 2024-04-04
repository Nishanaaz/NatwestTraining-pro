package org.example;

import org.example.dataAccessObject.AccountDao;
import org.example.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        AccountDao accountDao=(AccountDao) context.getBean("accountDao");  //this should be small
        accountDao.createAccount();

        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.createAccount();

    }
}