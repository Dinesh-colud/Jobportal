package com.dinesh.jobportal.serviceImpl;

import com.dinesh.jobportal.dto.UserRequest;
import com.dinesh.jobportal.dto.UserResponse;
import com.dinesh.jobportal.entity.User;
import com.dinesh.jobportal.exception.ResourceNotFoundException;
import com.dinesh.jobportal.repositories.UserRepository;
import com.dinesh.jobportal.service.UserService;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setRole(savedUser.getRole());

        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUsers() {

       List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> {
                    UserResponse response = new UserResponse();
                    response.setId(user.getId());
                    response.setName(user.getName());
                    response.setEmail(user.getEmail());
                    response.setRole(user.getRole());

                    return response;
                }).toList();
    }

    @Override
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id: "+id));

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());

        return userResponse;
    }

    @Override
    public UserResponse updateUser(UserRequest request, Long id) {

        Optional<User> existUser = userRepository.findByEmail(request.getEmail());

        if(existUser.isPresent() && !existUser.get().getId().equals(id)){
            throw new DuplicateRequestException("Email already exists!");
        }

        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found with id: "+id));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User updatedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(updatedUser.getId());
        userResponse.setName(updatedUser.getName());
        userResponse.setEmail(updatedUser.getEmail());
        userResponse.setRole(updatedUser.getRole());

        return userResponse;
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("User not found with id: "+id));

        userRepository.deleteById(id);
    }
}
