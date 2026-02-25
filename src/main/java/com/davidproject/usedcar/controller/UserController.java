package com.davidproject.usedcar.controller;

import com.davidproject.usedcar.dto.UsedCarUserDto;
import com.davidproject.usedcar.mapper.UsedCarUserMapper;
import com.davidproject.usedcar.service.interfaces.IUserService;
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

    private final IUserService userService;
    private final UsedCarUserMapper userMapper;

    @Autowired
    public UserController(IUserService userService, UsedCarUserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UsedCarUserDto> saveUser(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok(userMapper.toDto(userService.getOrCreateUser(jwt)));
    }
}
