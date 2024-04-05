package com.natwest.controller;


import com.natwest.entity.LoanRequest;
import com.natwest.exception.*;
import com.natwest.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class CustomerController {

    @Autowired
    private LoanService loanService;



    @PostMapping("/applyloan")
    public ResponseEntity<LoanRequest> applyLoan(@Valid @RequestBody LoanRequest loan) throws AlreadyAppliedForLoan, AadharIsNotValid, LoanAmountOutOfRoleAccessException, EmailIdNotValidException, InvalidUserSalariesException {
        loan.setStatus( "under review" );
        return new ResponseEntity<>( loanService.applyLoan( loan ), HttpStatus.CREATED );
    }



    @GetMapping("/customer/{username}")
    public ResponseEntity<LoanRequest> getCustomer(@PathVariable String username) throws UserNotFoundException {
        return new ResponseEntity<>( loanService.getLoanByUserName( username ), HttpStatus.OK );
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String username) throws UserNotFoundException {
        return new ResponseEntity<>( loanService.deleteLoanByUserName( username ), HttpStatus.OK );
    }

}