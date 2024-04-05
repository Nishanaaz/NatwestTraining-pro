package com.natwest.service;

import com.natwest.entity.EmployeeRole;
import com.natwest.entity.LoanRequest;
import com.natwest.exception.*;

import java.util.List;

public interface LoanService {

    public LoanRequest applyLoan(LoanRequest loanRequest) throws AlreadyAppliedForLoan, EmailIdNotValidException, AadharIsNotValid, LoanAmountOutOfRoleAccessException, InvalidUserSalariesException;

    public List<LoanRequest> getAllAppliedLoanDetails();

    public LoanRequest getLoanByUserName(String userName) throws UserNotFoundException;

    public String deleteLoanByUserName(String username) throws UserNotFoundException;

    public List<LoanRequest> allLoansDetailsFetchByEmployee(String employeeRole) throws IllegalArgumentException;

    LoanRequest getLoanByRequestId(long id) throws UserNotFoundException;

    LoanRequest updatedLoanStatus(EmployeeRole employeeRole, long id, LoanRequest loanRequest) throws LoanAmountOutOfRoleAccessException, UserNotFoundException;

}
