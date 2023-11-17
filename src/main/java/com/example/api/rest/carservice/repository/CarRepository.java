package com.example.api.rest.carservice.repository;

import com.example.api.rest.carservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
