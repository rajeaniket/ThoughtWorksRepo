package com.park;

public class ParkingSameCarAgainException extends Exception{

    private String message = "Car with this ID is already parked, can't park it again";
    public ParkingSameCarAgainException(){}

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
