package com.dinesh.jobportal.service;

import com.dinesh.jobportal.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(User user, Long id);

    void deleteUser(Long id);
}
