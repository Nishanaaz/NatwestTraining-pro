package com.natwest.controller;

import com.natwest.entity.UserProfile;
import com.natwest.exception.*;
import com.natwest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userservice")
public class UserProfileController {

    UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserProfile> registerUser(@RequestBody UserProfile userProfile) throws UserProfileAlreadyExistsException, InvalidContactNumberException, InvalidEmailIDException, InvalidAgeException {
        return new ResponseEntity(this.userService.registerUser(userProfile), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        return new ResponseEntity(this.userService.getAllUserProfiles(), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<UserProfile> getUserByUserName(@PathVariable String username) throws UserNameNotExistsException {
        return new ResponseEntity(this.userService.getUserProfile(username), HttpStatus.OK);
    }

    @PutMapping("/user/{username}")
    public ResponseEntity<String> updateRegistrationDetails(@PathVariable String username, @RequestBody UserProfile userProfile) throws UserNameNotExistsException {
        return new ResponseEntity(this.userService.updateUserRegistration(username, userProfile), HttpStatus.OK);
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<String> deleteRegistration(@PathVariable String username) throws UserNameNotExistsException {
        return new ResponseEntity(this.userService.deleteUserRegistration(username), HttpStatus.OK);
    }
}


