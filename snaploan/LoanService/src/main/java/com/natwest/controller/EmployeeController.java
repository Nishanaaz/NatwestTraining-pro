package com.natwest.controller;

import com.natwest.entity.EmployeeRole;
import com.natwest.entity.LoanRequest;
import com.natwest.exception.LoanAmountOutOfRoleAccessException;
import com.natwest.exception.UserNotFoundException;
import com.natwest.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    LoanService loanService;


    @GetMapping("/loan-requests")
    public ResponseEntity<List<LoanRequest>> getAllCustomerList()
    {
        return new ResponseEntity<>( loanService.getAllAppliedLoanDetails(), HttpStatus.OK );
    }




    @GetMapping("/loan-request/{employeeRole}")
    public ResponseEntity<List<LoanRequest>> getAllLoanRequests(@PathVariable String employeeRole) throws IllegalArgumentException {

        EmployeeRole role = EmployeeRole.valueOf(employeeRole.toUpperCase());
        List<LoanRequest> loans = loanService.allLoansDetailsFetchByEmployee( employeeRole );
        return new ResponseEntity<>( loans, HttpStatus.OK );
    }





    @PatchMapping("patchStatus/{employeeRole}/{id}")
    public ResponseEntity<LoanRequest> updateOneField(@PathVariable EmployeeRole employeeRole ,@PathVariable long id, @RequestBody LoanRequest loanRequest) throws LoanAmountOutOfRoleAccessException, UserNotFoundException {

        LoanRequest loan = loanService.updatedLoanStatus( employeeRole, id, loanRequest );

        return new ResponseEntity<>( loan, HttpStatus.OK );

    }



}
