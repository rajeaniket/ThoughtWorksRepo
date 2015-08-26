package com.park;

public class ParkingLotOwner implements ParkingLotObserver{
    private boolean parkingLotIsFull = false;
    
    public boolean isParkingLotFull() {
        return parkingLotIsFull;
    }

    @Override
    public void parkingLotFullNotification() {
        parkingLotIsFull = true;
    }

    public void parkingLotHasSpaceNotification() {
        parkingLotIsFull = false;
    }
}
