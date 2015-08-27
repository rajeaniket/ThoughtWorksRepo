package com.park;

public class ParkingFullException extends Exception {

    String message = "Parking Is Full, Can't Park Any More Cars.";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
