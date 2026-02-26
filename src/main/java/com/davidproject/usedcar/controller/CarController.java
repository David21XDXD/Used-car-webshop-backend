package com.davidproject.usedcar.controller;

import com.davidproject.usedcar.dto.CarCardDetails;
import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.service.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final ICarService carService;

    @Autowired
    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createCar(@AuthenticationPrincipal Jwt jwt, @RequestPart("car") CarRequest request, @RequestPart("images") List<MultipartFile> images) {
        carService.createCar(jwt, request, images);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarCardDetails>> getCars() {
        return ResponseEntity.ok(carService.getCars());
    }
}
