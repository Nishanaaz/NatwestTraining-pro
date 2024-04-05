package com.example.service;

import com.example.entity.LoanApplication;
import com.example.exception.LoanApplicationAlreadyExistsException;
import com.example.exception.LoanApplicationNotFoundException;
import com.example.repository.LoanApplicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoanApplicationServiceImplementationTest {
    @Mock
    LoanApplicationRepository loanApplicationRepository;
    @InjectMocks
    LoanApplicationServiceImplementation loanApplicationServiceImplementation;
    @Mock
    LoanApplication loanApplication;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveLoanApplicationToDbTest() throws LoanApplicationAlreadyExistsException {
        when(loanApplicationRepository.save(loanApplication)).thenReturn(loanApplication);
        LoanApplication retrieveLoanApplication = loanApplicationServiceImplementation.saveLoanApplicationToDb(loanApplication);
        assertEquals(loanApplication,retrieveLoanApplication);
    }
    @Test
    void loanApplicationAlreadyExist() throws LoanApplicationAlreadyExistsException{
        when(loanApplicationRepository.existsById(loanApplication.getId())).thenReturn(true);
        LoanApplicationAlreadyExistsException exception = assertThrows(LoanApplicationAlreadyExistsException.class,()->loanApplicationServiceImplementation.saveLoanApplicationToDb(loanApplication));
        assertTrue(exception.getMessage().contains("Loan Application already exists"));
    }

    @Test
    void approveLoanApplicationTest() throws LoanApplicationNotFoundException {

        when(loanApplicationRepository.findById(loanApplication.getId())).thenReturn(Optional.of(loanApplication));
        LoanApplication retrieveLoanApplication = loanApplicationServiceImplementation.approveLoanApplication(loanApplication.getId());
        assertEquals(retrieveLoanApplication,loanApplication);
    }
    @Test
    void applicationNotFoundException(){

    }

    @Test
    void rejectLoanApplicationTest() {
    }
}