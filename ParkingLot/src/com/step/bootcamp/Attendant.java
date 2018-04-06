package com.step.bootcamp;

import java.util.ArrayList;

public class Attendant implements ParkingLotListener {
    private ArrayList<ParkingLot> lots;

    public Attendant() {
        this.lots = new ArrayList<ParkingLot>();
    }

    public void addLot(ParkingLot lot) {
        lot.addListener(this);
        lots.add(lot);
    }

    public Object park(Vehicle vehicle) throws UnableToParkException {
        ParkingLot lotToPark = getFreeParkingLot();
        Object token = lotToPark.park(vehicle);
        return token;
    }

    private ParkingLot getFreeParkingLot() throws UnableToParkException {
        for (ParkingLot lot : lots) {
            if (!lot.isFull()){
                return lot;
            }
            System.out.println("full");
        }
        throw new UnableToParkException("All parking lots are full..");
    }


    public Vehicle checkout(Object token) throws NoSuchTokenException {
        for (ParkingLot lot : lots) {
            try {
                return lot.checkout(token);
            } catch (Exception e) {

            }
        }
        throw new NoSuchTokenException(token);

    }

    @Override
    public void full() {
        System.out.println("full");
    }

    @Override
    public void hasSpace() {
        System.out.println("Not full");
    }
}
