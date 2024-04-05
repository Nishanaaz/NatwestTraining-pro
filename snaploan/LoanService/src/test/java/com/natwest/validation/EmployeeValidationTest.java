package com.natwest.validation;

import com.natwest.entity.EmployeeRole;
import com.natwest.exception.LoanAmountOutOfRoleAccessException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeValidationTest {

    @InjectMocks
    private EmployeeValidation employeeValidation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validateLoanRequest() throws LoanAmountOutOfRoleAccessException {

        // Testing for Sales Manager role
        assertFalse( employeeValidation.validateLoanRequest( EmployeeRole.SALES_MANAGER, 1000.0) );
        assertFalse(employeeValidation.validateLoanRequest( EmployeeRole.SALES_MANAGER, 600000.0) );
        assertFalse( employeeValidation.validateLoanRequest( EmployeeRole.SALES_MANAGER, 500001.0) );
        assertTrue( employeeValidation.validateLoanRequest( EmployeeRole.SALES_MANAGER, 100000.0) );
        assertTrue( employeeValidation.validateLoanRequest( EmployeeRole.SALES_MANAGER, 500000.0) );
        assertTrue( employeeValidation.validateLoanRequest( EmployeeRole.SALES_MANAGER, 499999.0) );



        // Testing for manager level
        assertFalse( employeeValidation.validateLoanRequest( EmployeeRole.MANAGER, 1000.0) );
        assertFalse( employeeValidation.validateLoanRequest( EmployeeRole.MANAGER, -1.0) );
        assertFalse( employeeValidation.validateLoanRequest(EmployeeRole.MANAGER, 500000.0) );
        assertTrue( employeeValidation.validateLoanRequest(EmployeeRole.MANAGER, 600000.0) );
        assertTrue( employeeValidation.validateLoanRequest(EmployeeRole.MANAGER, 1000000.0) );


    }
}