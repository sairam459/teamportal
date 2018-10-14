package com.src.teamportal.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TPValidationException extends RuntimeException{
    public TPValidationException(String exception) {
        super(exception);
    }
}

