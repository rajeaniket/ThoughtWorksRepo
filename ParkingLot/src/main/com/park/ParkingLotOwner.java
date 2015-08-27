package com.park;

public class ParkingLotOwner implements ParkingLotObserver{
    private boolean parkingLotIsFull = false;

    @Override
    public void parkingLotFullNotification() {
        parkingLotIsFull = true;
    }

    @Override
    public void parkingLotHasSpaceNotification() {
        parkingLotIsFull = false;
    }
}
