package com.step.bootcamp;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

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
    public void shouldReturnFalseAfterCheckoutCarFromParkingLotWhichIsFull() throws UnableToParkException, NoSuchTokenException {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new TestVehicle());
        Object secondCar = parkingLot.park(new TestVehicle());
        parkingLot.checkout(secondCar);
        assertFalse(parkingLot.isFull());
    }

    @Test
    public void lotShouldInformWhenItIsFullAfterParkingVehicle() throws UnableToParkException {
        ParkingLot lot = new ParkingLot(1);

        ParkingLotListener testAssistant = mock(ParkingLotListener.class);
        lot.addListener(testAssistant);
        lot.park(new TestVehicle());
        verify(testAssistant).full();
    }


    @Test
    public void lotShouldInformWhenItHasSpaceAfterUnParkingVehicle() throws UnableToParkException, NoSuchTokenException {
        ParkingLot lot = new ParkingLot(1);
        ParkingLotListener testAssistant = mock(ParkingLotListener.class);
        lot.addListener(testAssistant);
        Object token= lot.park(new TestVehicle());
        lot.checkout(token);
        verify(testAssistant).hasSpace();

    }

    private class TestVehicle implements Vehicle {
    }

    @Test
    public void lotShouldInformAllSubscribersWhenItHasSpaceAfterUnParkingVehicle() throws UnableToParkException, NoSuchTokenException {
        ParkingLot lot = new ParkingLot(1);
        ParkingLotListener testAssistant = mock(ParkingLotListener.class);
        ParkingLotListener anotherTestAssist = mock(ParkingLotListener.class);
        lot.addListener(testAssistant);
        lot.addListener(anotherTestAssist);
        Object token= lot.park(new TestVehicle());
        lot.checkout(token);
        verify(testAssistant).hasSpace();
        verify(anotherTestAssist).hasSpace();

    }


    @Test
    public void lotShouldInformAllWhenItIsFullAfterParkingVehicle() throws UnableToParkException {
        ParkingLot lot = new ParkingLot(1);
        ParkingLotListener testAssistant = mock(ParkingLotListener.class);
        ParkingLotListener anotherTestAssist =mock(ParkingLotListener.class);
        lot.addListener(testAssistant);
        lot.addListener(anotherTestAssist);
        lot.park(new TestVehicle());
        verify(testAssistant).full();
        verify(anotherTestAssist).full();
    }

    @Test
    public void lotShouldNotInformAllSubscribersOnlyAfterFullIsTriggered() throws UnableToParkException, NoSuchTokenException {
        ParkingLot lot = new ParkingLot(2);
        ParkingLotListener testAssistant = mock(ParkingLotListener.class);
        ParkingLotListener anotherTestAssist = mock(ParkingLotListener.class);
        lot.addListener(testAssistant);
        lot.addListener(anotherTestAssist);
        Object token= lot.park(new TestVehicle());
        lot.checkout(token);
        verify(testAssistant,never()).hasSpace();
        verify(anotherTestAssist,never()).hasSpace();
    }

}
