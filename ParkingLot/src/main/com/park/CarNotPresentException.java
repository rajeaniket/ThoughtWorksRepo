package com.park;

public class CarNotPresentException extends Exception {

    private String message = "Car was not parked at all in the parking lot";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
