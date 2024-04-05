package com.natwest.service;


import com.natwest.entity.UserProfile;
import com.natwest.exception.*;

import java.util.List;

public interface UserService {
        UserProfile registerUser(UserProfile profile) throws UserProfileAlreadyExistsException, InvalidAgeException,InvalidContactNumberException, InvalidEmailIDException;

        UserProfile getUserProfile(String username) throws UserNameNotExistsException;

        List<UserProfile> getAllUserProfiles();


        String updateUserRegistration(String username, UserProfile userProfile) throws UserNameNotExistsException;

        String deleteUserRegistration(String username) throws UserNameNotExistsException;
}


