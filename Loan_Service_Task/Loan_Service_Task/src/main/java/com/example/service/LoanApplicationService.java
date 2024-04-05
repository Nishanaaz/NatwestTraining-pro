package com.example.service;

import com.example.entity.LoanApplication;
import com.example.exception.LoanApplicationAlreadyExistsException;
import com.example.exception.LoanApplicationNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface LoanApplicationService {
    public LoanApplication saveLoanApplicationToDb(LoanApplication loanApplication) throws LoanApplicationAlreadyExistsException;
    public LoanApplication rejectLoanApplication(int loanId) throws LoanApplicationNotFoundException;
    public LoanApplication approveLoanApplication(int loanId) throws LoanApplicationNotFoundException;

    }
