package com.step.bootcamp;

import java.util.ArrayList;

public class Attendant {
    private ArrayList<ParkingLot> lots;

    public Attendant() {
        this.lots = new ArrayList<ParkingLot>();
    }

    public void addLot(ParkingLot lot) {
        lots.add(lot);
    }

    public Object park(Vehicle vehicle) throws UnableToParkException {
        ParkingLot lotToPark=getFreeParkingLot();
        return lotToPark.park(vehicle);
    }

    private ParkingLot getFreeParkingLot() throws UnableToParkException {
        ParkingLot LargeCapacityLot = lots.get(0);
        for (ParkingLot lot : lots) {
            if ((lot.isGreaterCapacityThan(LargeCapacityLot) && !lot.isFull()) || LargeCapacityLot.isFull()) {
                LargeCapacityLot = lot;
            }
        }
        if (!LargeCapacityLot.isFull()){
            return LargeCapacityLot;
        }
        throw  new UnableToParkException("All parking lots full");
    }


    public Vehicle  checkout(Object token) throws NoSuchTokenException {
        for (ParkingLot lot : lots) {
            try {
                return  lot.checkout(token);
            }catch (Exception e){

            }
        }
        throw new NoSuchTokenException(token);
    }
}
