package com.dinesh.jobportal.config;

import com.dinesh.jobportal.entity.Role;
import com.dinesh.jobportal.entity.User;
import com.dinesh.jobportal.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.findByEmail("recruiter@gmail.com").isEmpty()){

            User recruiter = new User();
            recruiter.setName("Default user");
            recruiter.setEmail("recruiter@gmail.com");
            recruiter.setPassword(passwordEncoder.encode("recruiter@123"));
            recruiter.setRole(Role.RECRUITER);

            userRepository.save(recruiter);

            System.out.println("Default is created!");
        } else {
            System.out.println("Recruiter already exists!");
        }

    }
}
