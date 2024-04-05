package com.natwest.validation;

import com.natwest.entity.EmployeeRole;
import com.natwest.entity.LoanRequest;
import com.natwest.exception.LoanAmountOutOfRoleAccessException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidation {

    public Boolean validateLoanRequest(EmployeeRole employeeRole, Double amount) throws LoanAmountOutOfRoleAccessException {
        if (employeeRole == EmployeeRole.SALES_MANAGER) {
            if (amount < 100000 || amount > 500000) {
                return false;
            }
        } else if (employeeRole == EmployeeRole.MANAGER) {
            if (amount <= 500000) {
                return false;
            }
        } else if (employeeRole != EmployeeRole.BRANCH_MANAGER) {
            return false;
        }
        return true;
    }


}
