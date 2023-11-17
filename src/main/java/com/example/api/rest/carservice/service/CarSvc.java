package com.example.api.rest.carservice.service;

import com.example.api.rest.carservice.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarSvc {

    Page<Car> findAll(Pageable page);

    Optional<Car> find(Long idCar);

    Car save(Car car);

    void delete(Long carId);
}
