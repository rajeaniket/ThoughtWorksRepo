package com.park;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {

    @Test
    public void isCarParked(){
        ParkingLot parking = new ParkingLot();
        Car firstCar = new Car(1);
        assertTrue(parking.park(firstCar));
    }

    @Test
    public void shouldBeTrueIfCapacityFull(){
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        ParkingLot parking = new ParkingLot();
        Car firstCar = new Car(2);
        Car secondCar = new Car(3);
        Car thirdCar = new Car(4);
        Car fourthCar = new Car(5);
        parking.park(firstCar);
        parking.park(secondCar);
        parking.park(thirdCar);
        parking.unPark(firstCar.getCarID());
        parking.park(fourthCar);
        assertTrue(parkingLotOwner.isParkingLotFull());
    }

    @Test
    public void shouldBeFalseIfCarAlreadyParked(){
        ParkingLot parking = new ParkingLot();
        Car newCar = new Car(2);
        parking.park(newCar);
        assertFalse(parking.park(newCar));
    }

    @Test
    public void shouldUnPark(){
        ParkingLot parking = new ParkingLot();
        Car newCar = new Car(5);
        parking.park(newCar);
        assertTrue(parking.unPark(5));
    }

    @Test
    public void shouldBeFalseIfAlreadyUnParked(){
        ParkingLot parking = new ParkingLot();
        Car newCar = new Car(5);
        parking.park(newCar);
        parking.unPark(5);
        assertFalse(parking.unPark(5));
    }

    @Test
    public void shouldBeFalseIfNotParkedAtAll(){
        ParkingLot parking = new ParkingLot();
        assertFalse(parking.unPark(5));
    }

}