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

    public ParkingLot assignMyParkingLot() throws ParkingFullException {

        ParkingLot allocatedParkingLot = parkingLotsList.get(selectingParkingLot());
        if (allParkingsAreFull()) {
            do {
                if (allocatedParkingLot.hasParkingSpace()) {
                    return allocatedParkingLot;
                } else
                    allocatedParkingLot = parkingLotsList.get(selectingParkingLot());
            }while (!allocatedParkingLot.hasParkingSpace());
        }
        throw new ParkingFullException();
    }

    private boolean allParkingsAreFull(){
        for (ParkingLot parkingLot : parkingLotsList){
            if(parkingLot.hasParkingSpace())
                return false;
        }
        return true;
    }

    private int selectingParkingLot() {
        return ((++parkingLotIndex) % parkingLotsList.size());
    }




}
