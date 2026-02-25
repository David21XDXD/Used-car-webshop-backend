package com.davidproject.usedcar.repository;

import com.davidproject.usedcar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
