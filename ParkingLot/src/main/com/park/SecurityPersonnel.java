package com.park;

public class SecurityPersonnel implements ParkingLotObserver {

    private boolean parkingLotIsFull = false;


    @Override
    public void parkingLotFullNotification() {
        parkingLotIsFull = true;
    }

    @Override
    public void parkingLotHasSpaceNotification() {

    }
}
