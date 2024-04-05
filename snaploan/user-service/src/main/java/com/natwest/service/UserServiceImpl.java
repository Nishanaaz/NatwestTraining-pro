package com.natwest.service;

import com.natwest.entity.UserProfile;
import com.natwest.exception.*;
import com.natwest.repository.UserProfileRepository;
import com.natwest.utility.AppConstantsForAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserProfileRepository userProfileRepository;

    @Autowired
    public UserServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile registerUser(UserProfile userProfile) throws InvalidAgeException, UserProfileAlreadyExistsException,InvalidEmailIDException, InvalidContactNumberException {
        if (userProfileRepository.existsById(userProfile.getUserName())) {
            throw new UserProfileAlreadyExistsException(AppConstantsForAPI.USER_ALREADY_EXIST);
        }
        if (userProfile.getAge() < 18 || userProfile.getAge() > 65) {
            throw new InvalidAgeException(AppConstantsForAPI.INVALID_AGE);

        }
        if ((!userProfile.getEmail().contains("@")) || (!userProfile.getEmail().contains(".")) || (userProfile.getEmail().indexOf("@") > userProfile.getEmail().lastIndexOf("."))) {
            throw new InvalidEmailIDException(AppConstantsForAPI.INVALID_EMAIL_ID);
        }
        if (!this.checkMobileNumber(userProfile.getContactNo())) {
            throw new InvalidContactNumberException(AppConstantsForAPI.INVALID_MOBILE_NO);
        }

        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile getUserProfile(String username) throws UserNameNotExistsException {
        return userProfileRepository.findById(username).orElseThrow(() -> new UserNameNotExistsException(AppConstantsForAPI.USERNAME_NOT_FOUND));
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public String updateUserRegistration(String username, UserProfile userProfile) throws UserNameNotExistsException {
        if(!userProfileRepository.existsById(username)) {
            throw new UserNameNotExistsException(AppConstantsForAPI.USERNAME_NOT_FOUND);

        }
        userProfileRepository.save(userProfile);
        return "User profile updated successfully.";
    }

    @Override
    public String deleteUserRegistration(String username) throws UserNameNotExistsException {
        if(!userProfileRepository.existsById(username)) {
            throw new UserNameNotExistsException(AppConstantsForAPI.USERNAME_NOT_FOUND);

        }
        userProfileRepository.deleteById(username);
        return "User profile deleted successfully.";
    }



    public boolean checkMobileNumber(String contactNo) {
        if (contactNo != null && contactNo.length() == 10) {
            char[] ch = contactNo.toCharArray();
            int var3 = ch.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                char c = ch[var4];
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

}

