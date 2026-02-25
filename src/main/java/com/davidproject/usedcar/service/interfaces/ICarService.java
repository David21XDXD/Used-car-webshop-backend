package com.davidproject.usedcar.service.interfaces;

import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.model.Car;
import org.springframework.security.oauth2.jwt.Jwt;

public interface ICarService {
    void createCar(Jwt jwt, CarRequest request);
}
