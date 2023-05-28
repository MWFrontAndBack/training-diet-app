package com.example.trainingdietappbackend.service;

import com.example.trainingdietappbackend.controllers.users.LoginResponse;
import com.example.trainingdietappbackend.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserDataValidationService {

    ResponseEntity<LoginResponse> validUserDataAndReturnHisDataIfSucced(User requestUser);


}
