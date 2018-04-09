package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {

    @Test
    public void shouldParkCarToParkingLot() throws UnableToParkException {
        ParkingLot twParkingLot = new ParkingLot(20);
        Object swiftToken=twParkingLot.park(new TestVehicle());
        assertNotNull(swiftToken);
    }

    @Test
    public void shouldCheckoutTheCarThatIHaveTokenOf() throws NoSuchTokenException, UnableToParkException {
        ParkingLot twParkingLot = new ParkingLot(20);
        TestVehicle swift = new TestVehicle();
        Object swiftToken=twParkingLot.park(swift);
        Object mySwiftCar=twParkingLot.checkout(swiftToken);
        assertThat(swift,is(mySwiftCar));
    }

    @Test(expected = NoSuchTokenException.class)
    public void shouldNotBeAbleCheckoutInvalidCar() throws NoSuchTokenException, UnableToParkException {
        ParkingLot twParkingLot = new ParkingLot(20);
        TestVehicle swift = new TestVehicle();
        Object swiftToken=twParkingLot.park(swift);
        twParkingLot.checkout(swiftToken);
        twParkingLot.checkout(swiftToken);
    }

    @Test
    public void shouldReturnTrueWhenParkingLotCapacityIsZero() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertTrue(parkingLot.isFull());
    }

    @Test
    public void shouldReturnFalseWhenParkingLotCapacityIsOneAndNoCarsParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertFalse(parkingLot.isFull());
    }

    @Test(expected = UnableToParkException.class)
    public void shouldNotAddCarWhenLotIsFull() throws UnableToParkException {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new TestVehicle());
        parkingLot.park(new TestVehicle());
        parkingLot.park(new TestVehicle());
    }

    @Test
    public void shouldReturnFlaseAfterCheckingoutCarFromParkingLotWhichIsFull() throws UnableToParkException, NoSuchTokenException {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new TestVehicle());
        Object secondCar = parkingLot.park(new TestVehicle());
        parkingLot.checkout(secondCar);
        assertFalse(parkingLot.isFull());
    }

    private class TestVehicle implements Vehicle {
    }

    @Test
    public void shouldReturnTrueIfTheGivenLotHasGreaterCapacityThanIt() {
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingLot lotToCompare = new ParkingLot(2);
        assertTrue(parkingLot.isGreaterCapacityThan(lotToCompare));
    }

    @Test
    public void shouldReturnFalseIfTheGivenLotHasLesserCapacityThanIt() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot lotToCompare = new ParkingLot(3);
        assertFalse(parkingLot.isGreaterCapacityThan(lotToCompare));
    }
}
