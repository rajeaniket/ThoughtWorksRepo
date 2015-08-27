package com.park;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTest {

    @Mock
    ParkingLotObserver mockedOwner = new ParkingLotOwner();

    @Mock
    ParkingLotObserver mockedSecurity = new SecurityPersonnel();

    @Test
    public void isCarParked(){
        ParkingLot parking = new ParkingLot();
        Car firstCar = new Car(1);
        try {
            assertTrue(parking.park(firstCar) instanceof Token);
        } catch (ParkingSameCarAgainException e) {
            System.out.println(e.getMessage());
        } catch (ParkingFullException e) {
            System.out.println(e.getMessage());
        }
    }

   @Test(expected = ParkingSameCarAgainException.class)
    public void shouldThrowExceptionIfCarAlreadyParked() throws ParkingFullException, ParkingSameCarAgainException {
        ParkingLot parking = new ParkingLot();
        Car newCar = new Car(2);
            parking.park(newCar);
            parking.park(newCar);
    }

    @Test(expected = ParkingFullException.class)
    public void shouldThrowExceptionIfParkingIsFull() throws ParkingFullException, ParkingSameCarAgainException {
        ParkingLot parking = new ParkingLot();
        parking.park(new Car(1));
        parking.park(new Car(2));
        parking.park(new Car(3));
        parking.park(new Car(4));
    }

    @Test
    public void shouldUnPark() throws CarNotPresentException,ParkingFullException, ParkingSameCarAgainException {
        ParkingLot parking = new ParkingLot();
            Token carToken = parking.park(new Car(7));
            assertTrue(parking.unPark(carToken) instanceof Car);
    }

    @Test(expected = CarNotPresentException.class)
    public void shouldThrowExceptionIfCarIsAlreadyUnParked() throws CarNotPresentException, ParkingSameCarAgainException, ParkingFullException{
        ParkingLot parking = new ParkingLot();
        Car newCar = new Car(5);
            Token carToken = parking.park(newCar);
            parking.unPark(carToken);
            parking.unPark(carToken);
    }

    @Test(expected = CarNotPresentException.class)
    public void shouldThrowExceptionIfCarNotPresent() throws CarNotPresentException{
        ParkingLot parking = new ParkingLot();
            assertFalse(parking.unPark(new Token(0)) instanceof Car);

    }

    @Test
    public void shouldCheckIfCapacityFullIsNotifiedToOwner() throws ParkingFullException, ParkingSameCarAgainException{

        ParkingLot parking = new ParkingLot();
        parking.subscribeForParkingLotFullNotification(mockedOwner);

            parking.park(new Car(2));
            parking.park(new Car(4));
            parking.park(new Car(3));

        verify(mockedOwner, times(1)).parkingLotFullNotification();
    }

    @Test
    public void shouldBeFalseIfCapacityFullNotifiedToOwner() throws ParkingSameCarAgainException, ParkingFullException{

        ParkingLot parking = new ParkingLot();
        parking.subscribeForParkingLotFullNotification(mockedOwner);

            parking.park(new Car(2));
            parking.park(new Car(4));

        verify(mockedOwner, times(0)).parkingLotFullNotification();
    }

    @Test
    public void shouldCheckIfOwnerIsNotifiedWhenSpaceIsAvailableAgain() throws ParkingFullException, ParkingSameCarAgainException, CarNotPresentException{
        ParkingLot parking = new ParkingLot();
        parking.subscribeForParkingLotFullNotification(mockedOwner);
        parking.subscribeForSpaceInParkingLot(mockedOwner);

            Token carToken1 = parking.park(new Car(2));
            parking.park(new Car(4));
            parking.park(new Car(3));
            parking.unPark(carToken1);

            verify(mockedOwner, times(1)).parkingLotHasSpaceNotification();

    }

    @Test
    public void shouldCheckHowManyTimesOwnerIsNotifiedWhenSpaceIsAvailableAgain() throws ParkingFullException, ParkingSameCarAgainException, CarNotPresentException{
        ParkingLot parking = new ParkingLot();
        parking.subscribeForParkingLotFullNotification(mockedOwner);
        parking.subscribeForSpaceInParkingLot(mockedOwner);

        Token carToken1 = parking.park(new Car(2));
        Token carToken2 = parking.park(new Car(4));
        parking.park(new Car(3));
        parking.unPark(carToken1);
        parking.unPark(carToken2);
        verify(mockedOwner, times(1)).parkingLotHasSpaceNotification();

    }

    @Test
    public void shouldNotifyOwnerCapacityFullOnlyOnce() throws ParkingSameCarAgainException{

        ParkingLot parking = new ParkingLot();
        parking.subscribeForParkingLotFullNotification(mockedOwner);

        try {
            parking.park(new Car(2));
            parking.park(new Car(4));
            parking.park(new Car(3));
            parking.park(new Car(5));
        } catch (ParkingFullException e) {
            e.printStackTrace();
        }finally {
            verify(mockedOwner, times(1)).parkingLotFullNotification();
        }
    }

    @Test
    public void shouldCheckIfCapacityFullIsNotifiedToSecurity() throws ParkingFullException, ParkingSameCarAgainException{

        ParkingLot parking = new ParkingLot();
        parking.subscribeForParkingLotFullNotification(mockedSecurity);

            parking.park(new Car(2));
            parking.park(new Car(4));
            parking.park(new Car(3));

        verify(mockedSecurity, times(1)).parkingLotFullNotification();
    }

    @Test
    public void shouldCheckIfCapacityFullIsNotifiedToSecurityOnlyOnce() throws ParkingSameCarAgainException{

        ParkingLot parking = new ParkingLot();
        parking.subscribeForParkingLotFullNotification(mockedSecurity);

        try {
            parking.park(new Car(2));
            parking.park(new Car(4));
            parking.park(new Car(3));
            parking.park(new Car(5));
        } catch (ParkingFullException e) {
            System.out.println(e);
        }finally {
            verify(mockedSecurity, times(1)).parkingLotFullNotification();
        }

    }
}