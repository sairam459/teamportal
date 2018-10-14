package com.src.teamportal.exception;



import java.time.Instant;
import java.util.Date;

public class ExceptionResponse {


    private int status;

    private String error;

    private String message;

    private long timestamp = Instant.now().toEpochMilli();

    private String exceptionValue;

    public ExceptionResponse(Date date, String message, String description) {
    }

    public ExceptionResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }

    ExceptionResponse(int status, String error, String message, String exceptionValue) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
        this.exceptionValue = exceptionValue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getExceptionValue() {
        return exceptionValue;
    }

    public void setExceptionValue(String exceptionValue) {
        this.exceptionValue = exceptionValue;
    }
}

