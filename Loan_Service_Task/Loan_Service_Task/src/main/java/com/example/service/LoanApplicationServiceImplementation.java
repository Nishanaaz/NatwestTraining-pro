package com.example.service;

import com.example.entity.LoanApplication;
import com.example.exception.LoanApplicationAlreadyExistsException;
import com.example.exception.LoanApplicationNotFoundException;
import com.example.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImplementation implements LoanApplicationService{
@Autowired LoanApplicationRepository loanApplicationRepository;
    @Override
    public LoanApplication saveLoanApplicationToDb(LoanApplication loanApplication) throws LoanApplicationAlreadyExistsException {
        if(loanApplicationRepository.existsById(loanApplication.getId())){
            throw new LoanApplicationAlreadyExistsException("Loan Application already exists");
        }
        return loanApplicationRepository.save(loanApplication);
    }

    @Override
    public LoanApplication approveLoanApplication(int loanId) throws LoanApplicationNotFoundException {
        if(!loanApplicationRepository.existsById(loanId)){
            throw new LoanApplicationNotFoundException("Loan Application Doesn't Exist");
        }
        return loanApplicationRepository.findById(loanId).get();
    }

    @Override
    public LoanApplication rejectLoanApplication(int loanId) throws LoanApplicationNotFoundException {
        if(!loanApplicationRepository.existsById(loanId)){
            throw new LoanApplicationNotFoundException("Loan Application Doesn't Exist");
        }
        return loanApplicationRepository.findById(loanId).get();
    }
}
