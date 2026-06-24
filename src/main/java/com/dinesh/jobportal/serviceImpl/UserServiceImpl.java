package com.dinesh.jobportal.serviceImpl;

import com.dinesh.jobportal.entity.User;
import com.dinesh.jobportal.repositories.UserRepository;
import com.dinesh.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists!");
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id: "+id));
    }

    @Override
    public User updateUser(User user, Long id) {

        User user1 = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id: "+id));

        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());

        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("User not found with id: "+id));

        userRepository.deleteById(id);
    }
}
