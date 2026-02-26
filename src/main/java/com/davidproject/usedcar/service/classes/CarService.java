package com.davidproject.usedcar.service.classes;

import com.davidproject.usedcar.dto.CarCardDetails;
import com.davidproject.usedcar.dto.CarRequest;
import com.davidproject.usedcar.mapper.CarMapper;
import com.davidproject.usedcar.model.Car;
import com.davidproject.usedcar.model.CarImage;
import com.davidproject.usedcar.model.UsedCarUser;
import com.davidproject.usedcar.repository.CarRepository;
import com.davidproject.usedcar.service.interfaces.ICarService;
import com.davidproject.usedcar.service.interfaces.IUserService;
import com.davidproject.usedcar.service.interfaces.ImageStorage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CarService implements ICarService {

    private final IUserService userService;
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final ImageStorage imageStorage;

    @Autowired
    public CarService(IUserService userService, CarRepository carRepository, CarMapper carMapper, ImageStorage imageStorage) {
        this.userService = userService;
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.imageStorage = imageStorage;
    }

    @Override
    @Transactional
    public void createCar(Jwt jwt, CarRequest request, List<MultipartFile> images) {
        UsedCarUser user = userService.getOrCreateUser(jwt);
        Car car = carMapper.toCar(request);
        car.setUser(user);
        if (images != null) {
            for (int i = 0; i < images.size(); i++) {
                MultipartFile file = images.get(i);
                String url = imageStorage.store(file);

                CarImage ci = new CarImage();
                ci.setUrl(url);
                ci.setSortOrder(i);
                ci.setCover(i == 0);
                ci.setCar(car);

                car.getImages().add(ci);
            }
        }
        carRepository.save(car);
    }

    @Override
    public List<CarCardDetails> getCars() {
        return carMapper.toDtoList(carRepository.findAll());
    }
}
