package com.src.teamportal.exception.mapper;

import com.src.teamportal.exception.ExceptionResponse;
import com.src.teamportal.exception.model.DataNotFoundException;
import com.src.teamportal.exception.model.TPValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(DataNotFoundException ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(1,"error",ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TPValidationException.class)
    public final ResponseEntity<ExceptionResponse> handleValidationException(TPValidationException ex, WebRequest request) {
        System.out.println("trigger2");
        ExceptionResponse errorDetails = new ExceptionResponse(2,"error",ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
