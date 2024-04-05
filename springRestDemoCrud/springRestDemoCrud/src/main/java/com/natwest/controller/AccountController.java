package com.natwest.controller;

import com.natwest.entity.Account;
import com.natwest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;
    @PostMapping("/account")
    public Account createNewAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }
    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable int id){
//       Optional<Account> account = accountRepository.findById(id);
//       if(account.isEmpty()) return null;
       return accountRepository.findById(id).get();
    }

    @PutMapping("/account/{id}")
    public Account updateAccount(@RequestBody Account account, @PathVariable int id){
        if(!accountRepository.existsById(id)) {
            System.out.println("account not found");
        }else{
            accountRepository.save(account);
        }return account;
    }
}
