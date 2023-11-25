package com.example.api.rest.carservice.controller;

import com.example.api.rest.carservice.exception.CarNotFoundException;
import com.example.api.rest.carservice.model.Car;
import com.example.api.rest.carservice.service.CarSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/v1/cars")
public class CarRestController {

    private final CarSvc carSvc;

    public CarRestController(@Autowired CarSvc carsvc){
        this.carSvc = carsvc;
    }

    @GetMapping
    public List<Car> listProjects(
            @RequestParam(name = "pageSize", defaultValue = "5") int pageSize ,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber
    ) {
        Pageable paging = PageRequest.of(
                pageNumber, pageSize, Sort.by("dbid").ascending());
        Page<Car> page = carSvc.findAll(paging);
        return page.getContent();
    }

    @GetMapping("/{carId}")
    public Car getCar(@PathVariable Long carId){
        return carSvc.find(carId).orElseThrow(() -> new CarNotFoundException("Car not found."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car){
        car.setDbid(0L);
        return carSvc.save(car);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Car updateCar(@RequestBody Car car){
        return carSvc.save(car);
    }

    @DeleteMapping("/{carId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Long deleteCar(@PathVariable Long carId){
        Car car = carSvc.find(carId).orElseThrow(()
                -> new CarNotFoundException("Car not found " + carId)
                );
        carSvc.delete(carId);
        return car.getDbid();
    }
}
