package com.davidproject.usedcar.service.interfaces;

import com.davidproject.usedcar.dto.CarCardDetails;
import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.model.Car;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICarService {
    void createCar(Jwt jwt, CarRequest request, List<MultipartFile> images);
    List<CarCardDetails> getCars();
}
