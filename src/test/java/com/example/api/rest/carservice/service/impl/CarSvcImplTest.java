package com.example.api.rest.carservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.api.rest.carservice.model.Car;
import com.example.api.rest.carservice.repository.CarRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CarSvcImpl.class})
@ExtendWith(SpringExtension.class)
class CarSvcImplTest {
    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarSvcImpl carSvcImpl;

    /**
     * Method under test: {@link CarSvcImpl#findAll(Pageable)}
     */
    @Test
    void testFindAll() {
        PageImpl<Car> pageImpl = new PageImpl<>(new ArrayList<>());
        when(carRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);
        Page<Car> actualFindAllResult = carSvcImpl.findAll(null);
        assertSame(pageImpl, actualFindAllResult);
        assertTrue(actualFindAllResult.toList().isEmpty());
        verify(carRepository).findAll(Mockito.<Pageable>any());
    }

    /**
     * Method under test: {@link CarSvcImpl#find(Long)}
     */
    @Test
    void testFindCar() {
        Car car = new Car();
        car.setDbid(1L);
        car.setPlate("Plate");
        car.setVersion(1L);
        Optional<Car> ofResult = Optional.of(car);
        when(carRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Car> actualFindCarResult = carSvcImpl.find(1L);
        assertSame(ofResult, actualFindCarResult);
        assertTrue(actualFindCarResult.isPresent());
        verify(carRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CarSvcImpl#save(Car)}
     */
    @Test
    void testCreateCar() {
        Car car = new Car();
        car.setDbid(1L);
        car.setPlate("Plate");
        car.setVersion(1L);
        when(carRepository.save(Mockito.<Car>any())).thenReturn(car);

        Car car2 = new Car();
        car2.setDbid(1L);
        car2.setPlate("Plate");
        car2.setVersion(1L);
        assertSame(car, carSvcImpl.save(car2));
        verify(carRepository).save(Mockito.<Car>any());
    }
}

