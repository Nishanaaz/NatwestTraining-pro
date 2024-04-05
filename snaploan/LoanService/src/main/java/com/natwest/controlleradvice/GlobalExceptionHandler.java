package com.natwest.controlleradvice;


import com.natwest.exception.*;
import com.natwest.utility.AppConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(AlreadyAppliedForLoan.class)
    public ResponseEntity<ErrorInfo> exceptionHandlerForAlreadyAppliedForLoan(AlreadyAppliedForLoan e){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage( e.getMessage() );
        errorInfo.setHttpStatus( HttpStatus.BAD_REQUEST );
        errorInfo.setLocalDateTime( LocalDateTime.now() );

        return new ResponseEntity<>( errorInfo, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(AadharIsNotValid.class)
    public ResponseEntity<ErrorInfo> exceptionHandlerForAadhar(AadharIsNotValid e){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage( e.getMessage() );
        errorInfo.setHttpStatus( HttpStatus.BAD_REQUEST );
        errorInfo.setLocalDateTime( LocalDateTime.now() );

        return new ResponseEntity<>( errorInfo, HttpStatus.BAD_REQUEST );
    }


    @ExceptionHandler(EmailIdNotValidException.class)
    public ResponseEntity<ErrorInfo> exceptionHandlerForEmail(EmailIdNotValidException e){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage( e.getMessage() );
        errorInfo.setHttpStatus( HttpStatus.BAD_REQUEST );
        errorInfo.setLocalDateTime( LocalDateTime.now() );

        return new ResponseEntity<>( errorInfo, HttpStatus.BAD_REQUEST );
    }


    @ExceptionHandler(LoanAmountOutOfRoleAccessException.class)
    public ResponseEntity<ErrorInfo> exceptionHandlerForLoanAmount(LoanAmountOutOfRoleAccessException e){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage( e.getMessage() );
        errorInfo.setHttpStatus( HttpStatus.BAD_REQUEST );
        errorInfo.setLocalDateTime( LocalDateTime.now() );

        return new ResponseEntity<>( errorInfo, HttpStatus.BAD_REQUEST );
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> exceptionHandlerForIllegalArgumentException(IllegalArgumentException e){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage( AppConstant.INVALID_ROLE_EXCEPTION );
        errorInfo.setHttpStatus( HttpStatus.BAD_REQUEST );
        errorInfo.setLocalDateTime( LocalDateTime.now() );

        return new ResponseEntity<>( errorInfo, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(InvalidUserSalariesException.class)
    public ResponseEntity<ErrorInfo> exceptionHandlerForArrayLengthOutOfRange(InvalidUserSalariesException e){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorMessage( e.getMessage() );
        errorInfo.setHttpStatus( HttpStatus.BAD_REQUEST );
        errorInfo.setLocalDateTime( LocalDateTime.now() );

        return new ResponseEntity<>( errorInfo, HttpStatus.BAD_REQUEST );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> resourcesNotFoundExceptionHandler(MethodArgumentNotValidException e){
        Map<String, String> resp = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach(( error ) ->{
            String feildName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            resp.put(feildName, message);
        });

        return new ResponseEntity<Map<String, String>>( resp, HttpStatus.BAD_REQUEST );
    }

}
