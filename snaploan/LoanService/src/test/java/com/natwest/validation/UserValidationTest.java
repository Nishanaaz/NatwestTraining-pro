package com.natwest.validation;

import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {

    @InjectMocks
    private UserValidation userValidation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isValidEmail() {
        assertFalse( userValidation.isValidEmail("user") );
        assertFalse( userValidation.isValidEmail( "user@" ) );
        assertFalse( userValidation.isValidEmail( "@example.com" ) );
        assertFalse( userValidation.isValidEmail( "user@example" ) );
        assertFalse( userValidation.isValidEmail( "user@example@com" ) );
        assertFalse( userValidation.isValidEmail( "user@.com" ) );
        assertFalse( userValidation.isValidEmail( null ) );
        assertFalse( userValidation.isValidEmail( "" ) );
        assertFalse( userValidation.isValidEmail( "  " ) );
        assertFalse( userValidation.isValidEmail( "user@example-.com" ) );

        assertTrue( userValidation.isValidEmail( "user@example.com" ) );
        assertTrue( userValidation.isValidEmail( "user123@example.com" ) );
        assertTrue( userValidation.isValidEmail( "usertest@example.co.uk" ) );
        assertTrue( userValidation.isValidEmail( "usertest@example.com" ) );
        assertTrue( userValidation.isValidEmail( "usertest123test@example.com" ) );

    }

    @Test
    void isValidUserSalaries() {

        ArrayList<Double> list = new ArrayList<>( Arrays.asList(6000.0, 5000.0, 9000.0));
        assertTrue( userValidation.isValidUserSalaries( list ) );

        ArrayList<Double> list1 = new ArrayList<>( Arrays.asList(5000.0, 9000.0));
        assertFalse( userValidation.isValidUserSalaries( list1) );

        ArrayList<Double> list2 = new ArrayList<>( Arrays.asList(6000.0, 5000.0, 9000.0, 7500.0));
        assertFalse( userValidation.isValidUserSalaries(list2) );

        ArrayList<Double> list3 = new ArrayList<>( Arrays.asList(6000.0, 5000.0, 4000.0));
        assertFalse( userValidation.isValidUserSalaries(list3 ));

        ArrayList<Double> list4 = new ArrayList<>( Arrays.asList(6000.0, null, 9000.0));
        assertFalse( userValidation.isValidUserSalaries(list4) );

        ArrayList<Double> list5 = new ArrayList<>( Arrays.asList(0.0, 0.0, 0.0));
        assertFalse( userValidation.isValidUserSalaries(list4) );
    }

    @Test
    void isValidAadharNumber() {

        assertTrue( userValidation.isValidAadharNumber("123456789012") );


        assertFalse( userValidation.isValidAadharNumber("12345678901") );
        assertFalse( userValidation.isValidAadharNumber("1234567890123") );
        assertFalse( userValidation.isValidAadharNumber("1234567890AB") );
        assertFalse( userValidation.isValidAadharNumber("1234 5678 9012") );
        assertFalse( userValidation.isValidAadharNumber("1234@5678#9012") );

    }
}