package com.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotAttendant {

    private List<ParkingLot> parkingLotsList = new ArrayList<>();
    private int parkingLotIndex;

    public ParkingLotAttendant() {
        parkingLotIndex = -1;
    }

    public void assignParkingLotsToAttendant(List<ParkingLot> parkingLots) {
        parkingLotsList = parkingLots;
    }

    public ParkingLot assignMyParkingLot() {
        return parkingLotsList.get(selectingParkingLot());
    }

    private int selectingParkingLot() {
        return ((++parkingLotIndex) % parkingLotsList.size());
    }


}
