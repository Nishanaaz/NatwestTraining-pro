package com.natwest.service;

import com.natwest.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();

}
