package com.example.controller;

import com.example.entity.UserRegistration;
import com.example.exception.*;
import com.example.repository.UserRepository;
import com.example.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @PostMapping("/user")
    public ResponseEntity<UserRegistration> userRegistration(@RequestBody UserRegistration user) throws NameCannotBeNull, MobileIsInvalidException, EmailIsInvalid, PasswordCanNotBeNull {
        return new ResponseEntity<>(userServiceImplementation.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserRegistration>> getUser(){
        return new ResponseEntity<>(userServiceImplementation.getUsers(),HttpStatus.OK);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<UserRegistration> getUserByEmailId(@PathVariable String id) throws EmailNotFound {
        return new ResponseEntity<>(userServiceImplementation.getUserByEmailId(id),HttpStatus.OK);
    }
}
