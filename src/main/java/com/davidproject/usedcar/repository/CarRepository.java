package com.davidproject.usedcar.repository;

import com.davidproject.usedcar.model.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @EntityGraph(attributePaths = "images")
    List<Car> findAll();
}
