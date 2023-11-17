package com.example.api.rest.carservice.service.impl;

import com.example.api.rest.carservice.model.Car;
import com.example.api.rest.carservice.repository.CarRepository;
import com.example.api.rest.carservice.service.CarSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarSvcImpl implements CarSvc {


    private CarRepository carRepository;

    public CarSvcImpl(@Autowired CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public Page<Car> findAll(Pageable page) {
        return  carRepository.findAll(page);
    }

    @Override
    public Optional<Car> find(Long idCar) {
        return carRepository.findById(idCar);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(Long carId) {
        carRepository.deleteById(carId);
    }
}
