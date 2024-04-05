package com.natwest.controller;

import com.natwest.entity.Account;
import com.natwest.exception.IdNotFoundException;
import com.natwest.exception.InValidAmountException;
import com.natwest.repository.AccountRepository;
import com.natwest.service.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountServiceImp accountService;
    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) throws InValidAmountException {
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAllAccount(){
        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) throws IdNotFoundException {
        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable int id) throws IdNotFoundException {
        return new ResponseEntity<>(accountService.deleteById(id),HttpStatus.OK);
    }

}
