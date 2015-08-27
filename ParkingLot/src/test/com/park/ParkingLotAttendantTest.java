package com.park;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParkingLotAttendantTest {

    @Test
    public void shouldCheckIfParkingLotIsAllocated(){
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingLot parkingLot3 = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingLotList.add(parkingLot3);
        attendant.assignParkingLotsToAttendant(parkingLotList);
        assertTrue(attendant.assignMyParkingLot() instanceof ParkingLot);
    }

    @Test
    public void shouldCheckIfRoundRobinAllocationIsDone(){
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingLot parkingLot3 = new ParkingLot();
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingLotList.add(parkingLot3);
        attendant.assignParkingLotsToAttendant(parkingLotList);

        assertEquals(parkingLot1, attendant.assignMyParkingLot());
        assertEquals(parkingLot2, attendant.assignMyParkingLot());
        assertEquals(parkingLot3, attendant.assignMyParkingLot());
        assertEquals(parkingLot1, attendant.assignMyParkingLot());
    }

}