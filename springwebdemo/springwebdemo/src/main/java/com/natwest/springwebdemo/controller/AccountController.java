package com.natwest.springwebdemo.controller;

import com.natwest.springwebdemo.modal.Account;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class AccountController {
    ArrayList<Account> accounts = new ArrayList<>();
    @PostMapping("/account")
    public Account addAccount(@RequestBody Account account){
        accounts.add(account);
        return account;
    }
    @GetMapping("/accounts")
    public ArrayList<Account> getAllAccounts(){
        return accounts;
    }
}
