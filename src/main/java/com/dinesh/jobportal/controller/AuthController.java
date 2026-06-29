package com.dinesh.jobportal.controller;

import com.dinesh.jobportal.authenticationDTO.JwtResponse;
import com.dinesh.jobportal.authenticationDTO.LoginRequest;
import com.dinesh.jobportal.authenticationDTO.SignupRequest;
import com.dinesh.jobportal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody SignupRequest request){

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.login(request));
    }

}
