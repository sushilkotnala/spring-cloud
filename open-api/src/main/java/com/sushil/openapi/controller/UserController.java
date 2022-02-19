package com.sushil.openapi.controller;

import com.sushil.openapi.api.UsersApi;
import com.sushil.openapi.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UsersApi {
    @Override
    public ResponseEntity<User> listUsers() {
        return null;
    }
}
