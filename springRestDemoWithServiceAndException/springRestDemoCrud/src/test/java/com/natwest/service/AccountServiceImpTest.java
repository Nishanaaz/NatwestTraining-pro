package com.natwest.service;

import com.natwest.entity.Account;
import com.natwest.exception.IdNotFoundException;
import com.natwest.exception.InValidAmountException;
import com.natwest.repository.AccountRepository;
import com.natwest.utility.AppConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountServiceImpTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountServiceImp accountServiceImp;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Account account;

    @Test
    void addAccountTest() throws InValidAmountException {
        when(account.getBalance()).thenReturn(2000.0);
        when(accountRepository.save(account)).thenReturn(account);

        Account account1 = accountServiceImp.addAccount(account);
        assertEquals(account,account1);

        when(account1.getBalance()).thenReturn(500.0);
        InValidAmountException exception = assertThrows(InValidAmountException.class,()->accountServiceImp.addAccount(account1));
        assertTrue(AppConstant.INVALID_AMOUNT_MESSAGE.equals(exception.getMessage()));
    }

    @Test
    void getAllAccountsTest() {
//        List<Account> accounts = Collections.singletonList(new Account(1, "John Doe", 2000, "Savings"));
        List<Account> accounts = new ArrayList<>();
        Account account1=new Account(1, "John Doe", 2000, "Savings");
        accounts.add(account1);
        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> retrieveAccount = accountServiceImp.getAllAccounts();
//        assertEquals(accounts,retrieveAccount);
//        assertEquals(accounts.size(),retrieveAccount.size());
        assertTrue(retrieveAccount.containsAll(accounts));

    }

    @Test
    void getAccountByIdTest() throws IdNotFoundException {
        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        Account retrieveAccount = accountServiceImp.getAccountById(account.getId());
        assertEquals(account, retrieveAccount);

        IdNotFoundException exception = assertThrows(IdNotFoundException.class,()->accountServiceImp.getAccountById(2));
        assertTrue(exception.getMessage().equals(AppConstant.API_ID_NOT_FOUND_MESSAGE));
    }

    @Test
    void deleteByIdTest() throws IdNotFoundException {
        int accountId=1;
        when(accountRepository.existsById(accountId)).thenReturn(true);
        String result = accountServiceImp.deleteById(accountId);
        assertEquals("Account id " + accountId + " deleted successfully", result);
        IdNotFoundException exception = assertThrows(IdNotFoundException.class,()->accountServiceImp.getAccountById(2));
        assertTrue(exception.getMessage().equals(AppConstant.API_ID_NOT_FOUND_MESSAGE));

    }

    @Test
    void getAccountaByAccountType() {
    }

    @Test
    void updateAccountTest() throws IdNotFoundException {
        int id =1;
        Account account1 = new Account(1,"Nisha",10000,"saving");
        when(accountRepository.existsById(id)).thenReturn(true);
        when(accountRepository.save(account1)).thenReturn(account1);

        Account account = accountServiceImp.updateAccount(id,account1);
        assertEquals(account,account1);
        IdNotFoundException exception = assertThrows(IdNotFoundException.class,()->accountServiceImp.getAccountById(2));
        assertTrue(exception.getMessage().equals(AppConstant.API_ID_NOT_FOUND_MESSAGE));
    }
}