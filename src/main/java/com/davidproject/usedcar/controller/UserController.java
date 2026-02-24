package com.davidproject.usedcar.controller;

import com.davidproject.usedcar.model.UsedCarUser;
import com.davidproject.usedcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UsedCarUser> saveUser(@AuthenticationPrincipal Jwt jwt) {
        UsedCarUser user = userService.getOrCreateUser(jwt);
        return ResponseEntity.ok(user);
    }
}
