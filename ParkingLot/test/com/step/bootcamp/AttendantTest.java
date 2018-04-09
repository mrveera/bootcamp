package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AttendantTest {

    private Attendant attendant;

    @Before
    public void setUp() throws Exception {
        attendant = new Attendant();
    }

    @Test
    public void attendantShouldParkCarInOneParkingLot() throws UnableToParkException {
        Attendant attendant = new Attendant();
        attendant.addLot(new ParkingLot(1));
        Object token = attendant.park(new TestCar());
        assertNotNull(token);
    }

    @Test
    public void attendantShouldAddCarToSecondLotWhenFirstLotHasNoSpace() throws UnableToParkException {
        Attendant attendant = new Attendant();
        attendant.addLot(new ParkingLot(0));
        attendant.addLot(new ParkingLot(1));
        Object token = attendant.park(new TestCar());
        assertNotNull(token);
    }

    @Test(expected = UnableToParkException.class)
    public void shoulNotAddCarWhenAllParkingLotsFull() throws UnableToParkException {
        Attendant attendant = new Attendant();
        attendant.addLot(new ParkingLot(0));
        attendant.addLot(new ParkingLot(0));
        attendant.park(new TestCar());
    }

    private class TestCar implements Vehicle {
    }


    @Test
    public void shouldBeAbleToCheckoutParkedCarInOneLot() throws UnableToParkException, NoSuchTokenException {
        Attendant attendant = new Attendant();
        attendant.addLot(new ParkingLot(1));
        TestCar swift = new TestCar();
        Object token = attendant.park(swift);
        Vehicle mySwift=attendant.checkout(token);
        assertThat(swift,is(mySwift));
    }

    @Test
    public void shoudBeAbleCheckoutCarParkedInSecondLot() throws UnableToParkException, NoSuchTokenException {
        attendant.addLot(new ParkingLot(0));
        attendant.addLot(new ParkingLot(1));
        TestCar swift = new TestCar(); 
        Object token = attendant.park(swift);
        Vehicle mySwift= attendant.checkout(token);
        assertThat(swift,is(mySwift));
    }


    @Test(expected = NoSuchTokenException.class)
    public void shouldNotBeAbleCheckoutCarWhichIsUnParked() throws UnableToParkException, NoSuchTokenException {
        attendant.addLot(new ParkingLot(0));
        attendant.addLot(new ParkingLot(1));
        Object token=attendant.park(new TestCar());
        attendant.checkout(token);
        attendant.checkout(token);
    }
}
