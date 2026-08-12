package com.dinesh.jobportal.config;

import com.dinesh.jobportal.entity.Role;
import com.dinesh.jobportal.entity.User;
import com.dinesh.jobportal.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

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

            log.info("Default recruiter account created");
        } else {
            log.info("Recruiter already exists, skipping seed data");
        }

    }
}
