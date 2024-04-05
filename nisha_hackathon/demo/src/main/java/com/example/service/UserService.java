package com.example.service;

import com.example.entity.UserRegistration;
import com.example.exception.*;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserRegistration addUser(UserRegistration userRegistration) throws EmailIsInvalid, MobileIsInvalidException, NameCannotBeNull, PasswordCanNotBeNull;
    public UserRegistration getUserByEmailId(String id) throws EmailNotFound;
    public List<UserRegistration> getUsers();
}
