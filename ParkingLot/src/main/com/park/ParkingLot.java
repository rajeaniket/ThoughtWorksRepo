package com.park;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
    private final int capacity = 3;
    private Map<Integer, Car> cars = new HashMap<>();

    private void notifyOwner(){
        parkingLotOwner.parkingLotIsFull();
    }

    private boolean hasParkingSpace() {
        return cars.size() < capacity;
    }

    public boolean park(Car newCar) {
        if (hasParkingSpace()) {
            if (cars.put(newCar.getCarID(), newCar) == null) {
                if(cars.size() == capacity) {
                    notifyOwner();
                }
                return true;
            }
        }
        return false;
    }

    public boolean unPark(int carID) {
        for (int id : cars.keySet()) {
            if (id == carID) {
                cars.remove(carID);
                return true;
            }
        }
        return false;
    }

}
