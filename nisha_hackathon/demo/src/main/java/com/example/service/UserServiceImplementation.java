package com.example.service;

import com.example.entity.UserRegistration;
import com.example.exception.*;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository userRepository;

    public UserRegistration addUser(UserRegistration userRegistration) throws EmailIsInvalid, MobileIsInvalidException, NameCannotBeNull, PasswordCanNotBeNull {
        try {
            // Validate email
            if (!isValidEmail(userRegistration.getEmail_id())) {
                throw new EmailIsInvalid("Invalid email format");
            }

            // Validate mobile number
            if (!isValidMobile(userRegistration.getMobileNo())) {
                throw new MobileIsInvalidException("Mobile number should be 10 digits");
            }

            // Validate name
            if (userRegistration.getName() == null || userRegistration.getName().isEmpty()) {
                throw new NameCannotBeNull("Name cannot be null or empty");
            }

            // Validate password
            if (userRegistration.getPassword() == null || userRegistration.getPassword().isEmpty()) {
                throw new PasswordCanNotBeNull("Password cannot be null or empty");
            }
            userRepository.save(userRegistration);
            return userRegistration;

        } catch (EmailIsInvalid | MobileIsInvalidException | NameCannotBeNull | PasswordCanNotBeNull e) {
            throw e;
        }
    }

    public UserRegistration getUserByEmailId(String id) throws EmailNotFound {
        return userRepository.findById(id).orElseThrow(()->new EmailNotFound("Email Id not found"));
    }

    public List<UserRegistration> getUsers() {
        return (List<UserRegistration>) userRepository.findAll();
    }

    private boolean isValidEmail(String email) {
        int at = email.indexOf("@");
        int dot = email.lastIndexOf(".");
        int space = email.indexOf(" ");

        if ((at != -1) &&
                (at != 0) &&
                (dot != -1) &&
                (dot != 0) &&
                (dot > at + 1) &&
                (email.length() > dot + 1) &&
                (space == -1)) {
//            System.out.println("Email address is valid.");
            return true;
        }
        else {
            System.out.println("Error !!! Email address is not valid.");
            return false;
        }
    }

    private boolean isValidMobile(String mobile) {
        return mobile != null && mobile.length() == 10;
    }
}
