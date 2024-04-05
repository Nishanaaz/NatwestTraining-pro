package com.example.controller;

import com.example.entity.LoanApplication;
import com.example.exception.LoanApplicationAlreadyExistsException;
import com.example.exception.LoanApplicationNotFoundException;
import com.example.repository.LoanApplicationRepository;
import com.example.service.LoanApplicationService;
import com.example.service.LoanApplicationServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class LoanApplicationController {
    @Autowired
    LoanApplicationRepository loanApplicationRepository;
    @Autowired
    LoanApplicationService loanApplicationService;
    @PostMapping("/applyLoan")
    ResponseEntity<LoanApplication> applyLoan(@RequestBody LoanApplication loanApplication){
        try {
            LoanApplication savedLoanApplication = loanApplicationService.saveLoanApplicationToDb(loanApplication);
            return new ResponseEntity<>(savedLoanApplication, HttpStatus.CREATED);
        } catch (LoanApplicationAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/approveLoan/{id}")
    public ResponseEntity<LoanApplication> approveLoan(@PathVariable int id){
        try{
            LoanApplication getLoanApp = loanApplicationService.approveLoanApplication(id);
            return new ResponseEntity<>(getLoanApp,HttpStatus.OK);
        } catch (LoanApplicationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/rejectLoan/{loanId}")
    ResponseEntity<LoanApplication> rejectLoan(@PathVariable int id){
        try{
            LoanApplication getLoanApp = loanApplicationService.approveLoanApplication(id);
            return new ResponseEntity<>(getLoanApp,HttpStatus.OK);
        } catch (LoanApplicationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
