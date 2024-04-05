package com.natwest.service;

import com.natwest.entity.UserProfile;
import com.natwest.exception.*;
import com.natwest.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class
UserServiceImplTest {

    @Mock
    UserProfileRepository userProfileRepository;


    @InjectMocks
    UserServiceImpl userServiceImpl;




    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser() throws InvalidAgeException, UserProfileAlreadyExistsException, InvalidContactNumberException, InvalidEmailIDException {
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(false);
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        assertEquals(userProfile,userServiceImpl.registerUser(userProfile));
    }

    @Test
    void registerUserWhenUserAlreadyExist(){
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        userProfileRepository.save(userProfile);
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(true);
        assertThrows(UserProfileAlreadyExistsException.class ,()-> userServiceImpl.registerUser(userProfile));
    }


    @Test
    void registerUserWhenAgeIsInvalid(){
        UserProfile userProfile = new UserProfile("John@12","John","Smith",12,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(false);
        assertThrows(InvalidAgeException.class,()-> userServiceImpl.registerUser(userProfile));
    }

    @Test
    void registerUserWhenEmailIsInvalid(){
        UserProfile userProfile = new UserProfile("John@12","John","Smith",22,"2234467890","johngmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(false);
        assertThrows(InvalidEmailIDException.class,()-> userServiceImpl.registerUser(userProfile));

    }

    @Test
    void registerUserWhenMobileNumberIsInvalid(){
        UserProfile userProfile = new UserProfile("John@12","John","Smith",22,"223446789@","john@gmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(false);
        assertThrows(InvalidContactNumberException.class,()-> userServiceImpl.registerUser(userProfile));

    }

    @Test
    void getUserProfile() throws UserNameNotExistsException {
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.findById(userProfile.getUserName())).thenReturn(Optional.of(userProfile));
        assertEquals(userProfile,userServiceImpl.getUserProfile("John@12"));
    }

    @Test
    void getUserProfileWhenUsernameNotFound(){
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.findById(userProfile.getUserName())).thenReturn(Optional.of(userProfile));
        assertThrows(UserNameNotExistsException.class,()-> userServiceImpl.getUserProfile("John"));
    }

    @Test
    void getAllUSerProfiles() {
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        List<UserProfile> usersList = new ArrayList<>();
        usersList.add(userProfile);
        when(userProfileRepository.findAll()).thenReturn(usersList);
        assertEquals(usersList.size(),userServiceImpl.getAllUserProfiles().size());
    }

    @Test
    void updateUserRegistration() throws UserNameNotExistsException {

        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(true);
        userProfile.setAge(24);
        when(userProfileRepository.save(userProfile)).thenReturn(userProfile);
        String msg = "User profile updated successfully.";
        assertEquals(msg,userServiceImpl.updateUserRegistration("John@12", userProfile));

    }

    @Test
    void updateUserWhenUserProfileIsNotExist(){
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(false);
        assertThrows(UserNameNotExistsException.class,()-> userServiceImpl.updateUserRegistration("John", userProfile));


    }

    @Test
    void deleteUserRegistration() throws UserNameNotExistsException {
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(true);
        userProfileRepository.deleteById(userProfile.getUserName());
        String msg = "User profile deleted successfully.";
        assertEquals(msg,userServiceImpl.deleteUserRegistration("John@12"));
    }

    @Test
    void deleteUserWhenUserNameNotExist(){
        UserProfile userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");
        when(userProfileRepository.existsById(userProfile.getUserName())).thenReturn(false);
        assertThrows(UserNameNotExistsException.class,()-> userServiceImpl.deleteUserRegistration("John"));
 

    }

    @Test
    void checkMobileNumber() {

        assertTrue(userServiceImpl.checkMobileNumber("1234567894"));
    }

    @Test
    void checkMobileNumberWhenNumberIsAlphaNumeric(){

        assertFalse(userServiceImpl.checkMobileNumber("123456@456"));
    }

    @Test
    void checkMobileNumberWhenItIsNull(){
        assertFalse(userServiceImpl.checkMobileNumber(""));
    }

    @Test
    void checkMobileNumberIsNotContainsTenDigits(){
        assertFalse(userServiceImpl.checkMobileNumber("2345"));
    }
}