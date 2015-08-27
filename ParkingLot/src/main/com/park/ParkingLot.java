package com.park;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private List<ParkingLotObserver> observersOfFullParking = new ArrayList<>();
    private List<ParkingLotObserver> observersOfSpaceInParkingLot = new ArrayList<>();
    private int currentTokenNumber = 0;
    private final int capacity = 3;
    private Map<Token, Car> cars = new HashMap<>();

    private Token generateToken() {
        return new Token(currentTokenNumber++);
    }

    public void subscribeForParkingLotFullNotification(ParkingLotObserver observer) {
        observersOfFullParking.add(observer);
    }

    public void subscribeForSpaceInParkingLot(ParkingLotObserver observer) {
        observersOfSpaceInParkingLot.add(observer);
    }


    private void notifyObserverOfFullParkingLot() {
        for (ParkingLotObserver observer : observersOfFullParking) {
            observer.parkingLotFullNotification();
        }
    }

    private void notifyObserverOfSpaceInParkingLot() {
        for (ParkingLotObserver observer : observersOfSpaceInParkingLot) {
            observer.parkingLotHasSpaceNotification();
        }
    }

    private boolean hasParkingSpace() {
        return cars.size() < capacity;
    }

    public Token park(Car newCar) throws ParkingSameCarAgainException, ParkingFullException {
        if (hasParkingSpace()) {
            if (!(cars.containsValue(newCar))) {
                Token carToken = generateToken();
                cars.put(carToken, newCar);
                if (cars.size() == capacity) {
                    notifyObserverOfFullParkingLot();
                }
                return carToken;
            }
            throw new ParkingSameCarAgainException();
        }
        throw new ParkingFullException();
    }

    public Car unPark(Token token) throws CarNotPresentException {
        if (cars.containsKey(token)) {
            Car toBeReturned = cars.get(token);
            cars.remove(token);
            if (cars.size() == capacity - 1) {
                notifyObserverOfSpaceInParkingLot();
            }
            return toBeReturned;
        }
        throw new CarNotPresentException();
    }

}