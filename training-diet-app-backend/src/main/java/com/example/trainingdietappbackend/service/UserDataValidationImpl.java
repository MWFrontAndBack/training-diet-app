package com.example.trainingdietappbackend.service;

import com.example.trainingdietappbackend.controllers.users.CreateUserController;
import com.example.trainingdietappbackend.controllers.users.LoginResponse;
//import com.example.trainingdietappbackend.entities.User;
import com.example.trainingdietappbackend.entities.User;
import com.example.trainingdietappbackend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDataValidationImpl implements UserDataValidationService{
    private PasswordEncoder passwordEncoder;

    private UserDetailsService userDetailsService;
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(CreateUserController.class);


    public UserDataValidationImpl(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<LoginResponse> validUserDataAndReturnHisDataIfSucced(User requestUser) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(requestUser.getEmail());
            if (passwordEncoder.matches(requestUser.getPassword(), userDetails.getPassword())) {
              User user = userRepository.findByEmail(requestUser.getEmail());
                logger.info("User exists, login successful");

                LoginResponse response = new LoginResponse();
                response.setSuccess(true);
                response.setMessage("Login successful");
                response.setUser(user);

                return ResponseEntity.ok(response);
            } else {
                logger.error("Invalid credentials");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new LoginResponse(false, "Invalid credentials", null));
            }
        } catch (UsernameNotFoundException ex) {
            logger.error("User not found: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(false, "User not found", null));
        }

    }
}
