package com.davidproject.usedcar.controller;

import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.model.Car;
import com.davidproject.usedcar.service.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final ICarService carService;

    @Autowired
    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Void> createCar(@AuthenticationPrincipal Jwt jwt, @RequestBody CarRequest request) {
        carService.createCar(jwt, request);
        return ResponseEntity.noContent().build();
    }
}
