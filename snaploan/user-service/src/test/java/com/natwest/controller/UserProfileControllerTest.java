package com.natwest.controller;

import com.natwest.entity.UserProfile;
import com.natwest.exception.*;
import com.natwest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserProfileControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserProfileController userProfileController;

    UserProfile userProfile;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userProfile = new UserProfile("John@12","John","Smith",23,"2234467890","john@gmail.com","John@345");

    }

    @Test
    void registerUser() throws InvalidAgeException, UserProfileAlreadyExistsException, InvalidContactNumberException, InvalidEmailIDException {
        when(userService.registerUser(userProfile)).thenReturn(userProfile);
        ResponseEntity<UserProfile> response = userProfileController.registerUser(userProfile);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(userProfile,response.getBody());

    }

    @Test
    void getAllUserProfiles() throws UserNameNotExistsException {
        when(userService.getUserProfile(userProfile.getUserName())).thenReturn(userProfile);
        ResponseEntity<UserProfile> response = userProfileController.getUserByUserName("John@12");
        assertEquals(userProfile,response.getBody());
    }

    @Test
    void getUserByUserName() {
        List<UserProfile> userList = new ArrayList<>();
        userList.add(userProfile);
        when(userService.getAllUserProfiles()).thenReturn(userList);
        ResponseEntity <List<UserProfile>> responseList = userProfileController.getAllUserProfiles();
        assertEquals(userList.size(),responseList.getBody().size());
        assertEquals(HttpStatus.OK,responseList.getStatusCode());
    }

    @Test
    void updateRegistrationDetails() throws UserNameNotExistsException {
        String expectedResponse = "User profile updated successfully.";
        when(userService.updateUserRegistration("John@12", userProfile)).thenReturn(expectedResponse);
        ResponseEntity <String> response = userProfileController.updateRegistrationDetails("John@12", userProfile);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(expectedResponse,response.getBody());
    }

    @Test
    void deleteRegistration() throws UserNameNotExistsException {
        String expectedResponse = "User profile deleted successfully.";
        when(userService.deleteUserRegistration("John@12")).thenReturn(expectedResponse);
        ResponseEntity <String> response = userProfileController.deleteRegistration("John@12");
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(expectedResponse,response.getBody());
    }
}