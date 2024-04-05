package com.natwest.service;

import com.natwest.entity.EmployeeRole;
import com.natwest.entity.LoanRequest;
import com.natwest.exception.*;
import com.natwest.repository.LoanRepository;
import com.natwest.utility.AppConstant;
import com.natwest.validation.EmployeeValidation;
import com.natwest.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserValidation userValidation;


    @Autowired
    private EmployeeValidation employeeValidation;



    //Customer will apply for login using this method

    @Override
    public LoanRequest applyLoan(LoanRequest loanRequest) throws AlreadyAppliedForLoan, EmailIdNotValidException, LoanAmountOutOfRoleAccessException, AadharIsNotValid, InvalidUserSalariesException {

        if(loanRepository.existsByUserName( loanRequest.getUserName() ))
        {
            throw new AlreadyAppliedForLoan( AppConstant.ALREADY_APPLIED_FOR_LOAN );
        }
        else if (!userValidation.isValidEmail( loanRequest.getEmail() )){
            throw new EmailIdNotValidException( AppConstant.EMAIL_IS_NOT_VALID );
        }
        else if (!userValidation.isValidAadharNumber( loanRequest.getAadharNo())) {
            throw new AadharIsNotValid(AppConstant.AADHAR_IS_NOT_VALID_EXCEPTION);
        }
        else if (!userValidation.isValidUserSalaries( loanRequest.getUserSalary() )) {
            throw new InvalidUserSalariesException(AppConstant.INVALID_USER_SALARIES_EXCEPTION);
        }

        return loanRepository.save( loanRequest );
    }





    //Customer will fetch data by username
    @Override
    public LoanRequest getLoanByUserName(String username) throws UserNotFoundException {
        if(!loanRepository.existsByUserName( username )){
            throw new UserNotFoundException( AppConstant.USERNAME_NOT_FOUND_EXCEPTION );
        }
        return loanRepository.findByUserName( username );
    }





    //Customer can delete account using username;
    public String deleteLoanByUserName(String username) throws UserNotFoundException {

        if(!loanRepository.existsByUserName( username )){
            throw new UserNotFoundException( AppConstant.USERNAME_NOT_FOUND_EXCEPTION );
        }

        LoanRequest l = loanRepository.findByUserName( username );
        loanRepository.delete( l );
        return "Your account is deleted succesfully";
    }





    //Employee will fetch all the customers detail applied for loan
    @Override
    public List<LoanRequest> getAllAppliedLoanDetails() {
        return loanRepository.findAll();
    }





    //Employee will fetch data of customer who have applied for loan using request id
    @Override
    public LoanRequest getLoanByRequestId(long id) throws UserNotFoundException {
        return loanRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Loan with ID " + id + " not found"));
    }





    // Employee will fetch details of all customers
    @Override
    public List<LoanRequest> allLoansDetailsFetchByEmployee(String employeeRole) throws IllegalArgumentException {

        EmployeeRole role = EmployeeRole.valueOf(employeeRole.toUpperCase());

        if (role == EmployeeRole.BRANCH_MANAGER || role == EmployeeRole.MANAGER || role == EmployeeRole.SALES_MANAGER ){
            return getAllAppliedLoanDetails();
        }

        throw new IllegalArgumentException();

    }







    // Giving access to employees according to their roles
    @Override
    public LoanRequest updatedLoanStatus(EmployeeRole employeeRole, long id, LoanRequest loanRequest) throws LoanAmountOutOfRoleAccessException, UserNotFoundException {

        LoanRequest loan = getLoanByRequestId( id );

        if (!employeeValidation.validateLoanRequest( employeeRole, loan.getLoanAmount( ) )) {
            throw new LoanAmountOutOfRoleAccessException( employeeRole + " can only update loan of " + loan.getLoanAmount( ) );
        }

        loan.setStatus( loanRequest.getStatus( ) );
        return loanRepository.save( loan );

    }

}
