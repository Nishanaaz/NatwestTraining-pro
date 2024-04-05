package com.natwest.service;

import com.natwest.entity.Account;
import com.natwest.exception.IdNotFoundException;
import com.natwest.exception.InValidAmountException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {public Account addAccount(Account account) throws InValidAmountException;
    public List<Account> getAllAccounts();
    public Account getAccountById(int id) throws IdNotFoundException;
    public String deleteById(int id) throws IdNotFoundException;
    public List<Account> getAccountaByAccountType(String name);
    public Account updateAccount(int id, Account account) throws IdNotFoundException;



}
