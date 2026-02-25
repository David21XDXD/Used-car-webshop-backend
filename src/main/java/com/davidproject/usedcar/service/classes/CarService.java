package com.davidproject.usedcar.service.classes;

import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.mapper.CarMapper;
import com.davidproject.usedcar.model.Car;
import com.davidproject.usedcar.model.UsedCarUser;
import com.davidproject.usedcar.repository.CarRepository;
import com.davidproject.usedcar.service.interfaces.ICarService;
import com.davidproject.usedcar.service.interfaces.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

    private final IUserService userService;
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarService(IUserService userService, CarRepository carRepository, CarMapper carMapper) {
        this.userService = userService;
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Transactional
    @Override
    public void createCar(Jwt jwt, CarRequest request) {
        UsedCarUser user = userService.getOrCreateUser(jwt);
        Car car = carMapper.toCar(request);
        car.setUser(user);
        carRepository.save(car);
    }
}
