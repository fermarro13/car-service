package com.example.api.rest.carservice.exception;

import com.example.api.rest.carservice.util.CarErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CarRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CarErrorResponse> handleException(CarNotFoundException ex){
        CarErrorResponse carErrorResponse = new CarErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(carErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CarErrorResponse> handleException(DataIntegrityViolationException ex){
        CarErrorResponse carErrorResponse = new CarErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Couldn't create car, please verify information.",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(carErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CarErrorResponse> handleException(Exception ex){
        CarErrorResponse carErrorResponse = new CarErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(carErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
