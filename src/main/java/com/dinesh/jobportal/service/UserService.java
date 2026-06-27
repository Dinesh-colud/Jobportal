package com.dinesh.jobportal.service;

import com.dinesh.jobportal.dto.UserRequest;
import com.dinesh.jobportal.dto.UserResponse;
import com.dinesh.jobportal.entity.User;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse updateUser(UserRequest request, Long id);

    void deleteUser(Long id);
}
