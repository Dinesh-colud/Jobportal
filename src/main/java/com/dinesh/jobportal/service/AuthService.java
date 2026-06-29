package com.dinesh.jobportal.service;

import com.dinesh.jobportal.authenticationDTO.JwtResponse;
import com.dinesh.jobportal.authenticationDTO.LoginRequest;
import com.dinesh.jobportal.authenticationDTO.SignupRequest;

public interface AuthService {

    String register(SignupRequest request);

    JwtResponse login(LoginRequest request);

}
