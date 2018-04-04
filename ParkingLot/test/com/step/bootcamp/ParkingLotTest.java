package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkCarToParkingLot() {
        ParkingLot twParkingLot = new ParkingLot(20);
        Car swift = new Car("Swift", "AP-05-AJ-3476");
        ParkingToken swiftToken=twParkingLot.park(new Object());
        assertNotNull(swiftToken);
    }

    @Test
    public void shouldCheckoutTheCarThatIHaveTokenOf() throws ParkingLot.NoSuchTokenException {
        ParkingLot twParkingLot = new ParkingLot(20);
        Car swift = new Car("Swift", "AP-05-AJ-3476");
        ParkingToken swiftToken=twParkingLot.park(swift);
        Object mySwiftCar=twParkingLot.checkout(swiftToken);
        assertThat(swift,is(mySwiftCar));
    }

    @Test(expected = ParkingLot.NoSuchTokenException.class)
    public void shouldNotContainCheckedOutCar() throws ParkingLot.NoSuchTokenException {
        ParkingLot twParkingLot = new ParkingLot(20);
        Car swift = new Car("Swift", "AP-05-AJ-3476");
        ParkingToken swiftToken=twParkingLot.park(swift);
        Object mySwiftCar=twParkingLot.checkout(swiftToken);
        twParkingLot.checkout(swiftToken);
    }



}
