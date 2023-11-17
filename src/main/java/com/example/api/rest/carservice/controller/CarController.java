package com.example.api.rest.carservice.controller;

import com.example.api.rest.carservice.model.Car;
import com.example.api.rest.carservice.service.CarSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarSvc carSvc;

    public CarController(@Autowired CarSvc carsvc){
        this.carSvc = carsvc;
    }

    @GetMapping
    public List<Car> listProjects(
            @RequestParam("pageSize") int pageSize,
            @RequestParam("pageNumber") int pageNumber
    ) {
        Pageable paging = PageRequest.of(
                pageNumber, pageSize, Sort.by("dbid").ascending());
        Page<Car> page = carSvc.findAll(paging);
        return page.getContent();
    }


}
