package com.booking.valueobjects.infraestructure.api;

import com.booking.valueobjects.domain.exception.DataDomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvicer {

    @ExceptionHandler(DataDomainException.class)
    public ResponseEntity<Object> handleDomainException(DataDomainException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
