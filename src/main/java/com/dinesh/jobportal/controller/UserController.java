package com.dinesh.jobportal.controller;

import com.dinesh.jobportal.dto.UserRequest;
import com.dinesh.jobportal.dto.UserResponse;
import com.dinesh.jobportal.entity.User;
import com.dinesh.jobportal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
        UserResponse user1 = userService.createUser(request);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        UserResponse user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUsers(@RequestBody UserRequest request,
                                            @PathVariable Long id){
        UserResponse user1 = userService.updateUser(request, id);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
         userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }

}
