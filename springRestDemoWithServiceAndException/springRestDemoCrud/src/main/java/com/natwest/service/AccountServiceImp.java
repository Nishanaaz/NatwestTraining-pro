package com.natwest.service;

import com.natwest.entity.Account;
import com.natwest.exception.IdNotFoundException;
import com.natwest.exception.InValidAmountException;
import com.natwest.repository.AccountRepository;
import com.natwest.utility.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) throws InValidAmountException {
        if (account.getBalance()<=1000)
            throw new InValidAmountException(AppConstant.INVALID_AMOUNT_MESSAGE);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(int id) throws IdNotFoundException {
       return accountRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstant.API_ID_NOT_FOUND_MESSAGE));
    }

    @Override
    public String deleteById(int id) throws IdNotFoundException {
        if(!accountRepository.existsById(id))
            throw new IdNotFoundException("Id was invalid");
        else{
            accountRepository.deleteById(id);
        return  "Account id "+id+ " deleted successfully";
        }
    }

    @Override
    public List<Account> getAccountaByAccountType(String name) {
        return accountRepository.findByAccountType(name);
    }

    @Override
    public Account updateAccount(int id, Account account) throws IdNotFoundException {
        if(!accountRepository.existsById(id))
            throw new IdNotFoundException("Id was invalid");
        else{
            accountRepository.save(account);
            return account;
        }
    }
}
