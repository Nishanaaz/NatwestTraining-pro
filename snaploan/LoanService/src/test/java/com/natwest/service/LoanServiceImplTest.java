package com.natwest.service;

import com.natwest.entity.EmployeeRole;
import com.natwest.entity.LoanRequest;
import com.natwest.exception.*;
import com.natwest.repository.LoanRepository;
import com.natwest.validation.EmployeeValidation;
import com.natwest.validation.UserValidation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.natwest.entity.EmployeeRole.MANAGER;
import static com.natwest.entity.EmployeeRole.SALES_MANAGER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoanServiceImplTest {

    @Mock
    private LoanRequest loanRequest;

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private UserValidation userValidation;

    @Mock
    private EmployeeValidation employeeValidation;
    private ArrayList<Double> list ;

    @InjectMocks
    private LoanServiceImpl loanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );

        list = new ArrayList<>( Arrays.asList(60000.0, 65000.0, 70000.0));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void applyLoan() throws InvalidUserSalariesException, AadharIsNotValid, AlreadyAppliedForLoan, EmailIdNotValidException, LoanAmountOutOfRoleAccessException {

        when( loanRepository.existsByUserName( loanRequest.getUserName() ) ).thenReturn( false );
        when( userValidation.isValidEmail( loanRequest.getEmail() ) ).thenReturn( true );
        when( userValidation.isValidAadharNumber( loanRequest.getAadharNo() ) ).thenReturn( true );
        when( userValidation.isValidUserSalaries( loanRequest.getUserSalary() ) ).thenReturn( true );
        when( loanRepository.save( loanRequest ) ).thenReturn( loanRequest );

        assertEquals( loanRequest, loanService.applyLoan(loanRequest) );


    }

    @Test
    void exceptionThrownIfUserAppliedForLoan() {

        when( loanRepository.existsByUserName( loanRequest.getUserName() ) ).thenReturn( true );

        assertThrows( AlreadyAppliedForLoan.class, ()-> loanService.applyLoan( loanRequest ) );
    }


    @Test
    void exceptionThrownEmailIsNotValid() {

        when( userValidation.isValidEmail( loanRequest.getEmail() ) ).thenReturn( false );

        assertThrows( EmailIdNotValidException.class, ()-> loanService.applyLoan( loanRequest ) );


    }


    @Test
    void exceptionThrownAadharIsNotValid() {

        when( userValidation.isValidEmail( loanRequest.getEmail() ) ).thenReturn( true );

        when( userValidation.isValidAadharNumber( loanRequest.getAadharNo() ) ).thenReturn( false );

        assertThrows( AadharIsNotValid.class, ()-> loanService.applyLoan( loanRequest ) );
    }


    @Test
    void exceptionThrownUSerSalaries() {

        when( userValidation.isValidEmail( loanRequest.getEmail() ) ).thenReturn( true );

        when( userValidation.isValidAadharNumber( loanRequest.getAadharNo() ) ).thenReturn( true );

        when( userValidation.isValidUserSalaries( loanRequest.getUserSalary() ) ).thenReturn( false );

        assertThrows( InvalidUserSalariesException.class, ()-> loanService.applyLoan( loanRequest) );


    }



    @Test
    void getLoanByUserName() throws UserNotFoundException {
        when( loanRepository.existsByUserName( loanRequest.getUserName() ) ).thenReturn( true );
        when( loanRepository.findByUserName( loanRequest.getUserName() ) ).thenReturn( loanRequest );
        assertEquals( loanRequest, loanService.getLoanByUserName( loanRequest.getUserName() ) );
    }

    @Test
    void userNameDoesNotExistThenThrowException() throws UserNotFoundException {
        when( loanRepository.existsByUserName( loanRequest.getUserName() ) ).thenReturn( false );
        assertThrows( UserNotFoundException.class, ()-> loanService.getLoanByUserName( loanRequest.getUserName() ) );
    }

    @Test
    void deleteLoanByUserName() throws UserNotFoundException {

        when( loanRepository.existsByUserName( loanRequest.getUserName() ) ).thenReturn( true );

        LoanRequest l = loanRepository.findByUserName( loanRequest.getUserName() );
        loanRepository.delete( l );

        assertEquals( "Your account is deleted succesfully",loanService.deleteLoanByUserName( loanRequest.getUserName() ));
    }

    @Test
    void deleteByUserNameExceptionThrow() {
        when(loanRepository.existsByUserName( loanRequest.getUserName() )).thenReturn( false );
        assertThrows( UserNotFoundException.class, ()-> loanService.deleteLoanByUserName( loanRequest.getUserName() ) );
    }

    @Test
    void getAllAppliedLoanDetails() {
        List<LoanRequest> users = loanRepository.findAll( );
        assertEquals( users, loanService.getAllAppliedLoanDetails() );

        List<LoanRequest> usersLoanRequestList = new ArrayList<>();
        when(loanRepository.findAll()).thenReturn( usersLoanRequestList );
        List<LoanRequest> result = loanService.getAllAppliedLoanDetails( );
        assertEquals( usersLoanRequestList.size(), result.size() );
    }



    @Test
    void getLoanByRequestId() throws UserNotFoundException {

        when(loanRepository.existsById( loanRequest.getRequestedId() )).thenReturn( true );

        when( loanRepository.findById( loanRequest.getRequestedId() ) ).thenReturn( Optional.of( loanRequest ) );

        assertEquals( loanRequest, loanService.getLoanByRequestId( loanRequest.getRequestedId() ) );
    }

    @Test
    void loanRequestIdDoesNotExistThrowException () {

    when( loanRepository.existsById( loanRequest.getRequestedId() ) ).thenReturn( false );

    assertThrows( UserNotFoundException.class, ()->loanService.getLoanByRequestId( loanRequest.getRequestedId() ) );

    }



    @Test
    void allLoansDetailsFetchByEmployee() {

        String role = "manager";
        List<LoanRequest> list = loanRepository.findAll();
        List<LoanRequest> result = loanService.allLoansDetailsFetchByEmployee( role );

        assertEquals( list,  result);
        assertEquals( list.size(), result.size() );

        String role1 = "sales_manager";
        List<LoanRequest> result1 = loanService.allLoansDetailsFetchByEmployee( role1 );

        assertEquals( list, result1 );
        assertEquals( list.size(), result1.size() );


        String role2 = "sales_manager";
        List<LoanRequest> result2 = loanService.allLoansDetailsFetchByEmployee( role2 );

        assertEquals( list, result2 );
        assertEquals( list.size(), result2.size() );

    }


    @Test
    void InvalidRoleCheck(){

        String role = "teacher";

        assertThrows( IllegalArgumentException.class, ()->loanService.allLoansDetailsFetchByEmployee( role ) );
    }

    @Test
    void updatedLoanStatusBySalesManager() throws UserNotFoundException, LoanAmountOutOfRoleAccessException {

        loanRequest = new LoanRequest( 1, "John", "john@example.com", 35, 100000.0, 750, 2, "123456789012", list , "Married", "Engineer", new BigDecimal( 800000 ), "123 Main Street", "Pending");

        EmployeeRole employeeRole = SALES_MANAGER;
        long id = loanRequest.getRequestedId();

        LoanRequest l = new LoanRequest();
        l.setStatus( "approve" );

        when( loanRepository.findById( loanRequest.getRequestedId() ) ).thenReturn( Optional.of( loanRequest ) );
        when(employeeValidation.validateLoanRequest( employeeRole, loanRequest.getLoanAmount( ) )).thenReturn( true );

        loanRequest.setStatus( l.getStatus() );
        when( loanRepository.save( loanRequest )).thenReturn( loanRequest );

        LoanRequest updatedLoan = loanService.updatedLoanStatus( employeeRole, id , l );

        assertEquals( l.getStatus(), updatedLoan.getStatus() );
    }


    @Test
    void updatedLoanStatusThrowsExceptionWhenLoanAmountOutOfRoleRange() throws LoanAmountOutOfRoleAccessException {
        loanRequest = new LoanRequest( 1, "John", "john@example.com", 35, 100000.0, 750, 2, "123456789012", list , "Married", "Engineer", new BigDecimal( 800000 ), "123 Main Street", "Pending");

        EmployeeRole employeeRole = SALES_MANAGER;
        long id = loanRequest.getRequestedId();

        LoanRequest l = new LoanRequest();
        l.setStatus( "approve" );

        when( loanRepository.findById( loanRequest.getRequestedId() ) ).thenReturn( Optional.of( loanRequest ) );
        when(employeeValidation.validateLoanRequest( employeeRole, loanRequest.getLoanAmount( ) )).thenReturn( false );

        assertThrows( LoanAmountOutOfRoleAccessException.class, ()->loanService.updatedLoanStatus( employeeRole, id, l ) );


        EmployeeRole employeeRole1 = MANAGER;
        long id1 = loanRequest.getRequestedId();

        LoanRequest loan1 = new LoanRequest();
        loan1.setStatus( "approve" );

        when( loanRepository.findById( loanRequest.getRequestedId() ) ).thenReturn( Optional.of( loanRequest ) );
        when(employeeValidation.validateLoanRequest( employeeRole1, loanRequest.getLoanAmount( ) )).thenReturn( false );

        assertThrows( LoanAmountOutOfRoleAccessException.class, ()->loanService.updatedLoanStatus( employeeRole1, id1, loan1 ) );


    }


}