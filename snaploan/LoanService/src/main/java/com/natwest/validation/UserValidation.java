package com.natwest.validation;

import com.natwest.entity.LoanRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserValidation {

    public Boolean isValidEmail(String email) {

        if(email == null || email.isEmpty() || email.isBlank()){
            return false;
        }

        String EMAIL_PATTERN = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    public boolean isValidUserSalaries(ArrayList<Double> userSalary){
        if(userSalary.size() == 3 && userSalary != null){

            boolean valid = true;

            for(Double salary: userSalary){
                if(salary == null || salary < 5000){
                    valid = false;
                    break;
                }
            }
            return valid;
        }
        return false;
    }



    public boolean isValidAadharNumber(String aadharNumber ){
        if( aadharNumber == null || aadharNumber.length() != 12 || !aadharNumber.matches("\\d{12}")){
            return false;
        }

        return true;
    }




}
