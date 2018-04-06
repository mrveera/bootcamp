package com.step.bootcamp;

import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private HashMap<Object,Vehicle> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars=new HashMap(capacity);
    }

    public Object park(Vehicle vehicle) throws UnableToParkException {
        if(isAlredyParked(vehicle)) {
            throw new UnableToParkException("The vehicle you are trying to park is already parked");
        }
        if(isFull()) {
            throw new UnableToParkException("Parking lot is full try after sometime ...");
        }
        Object token = new Object();
        parkedCars.put(token, vehicle);
        return token;
    }

    private boolean isAlredyParked(Vehicle vehicle) {
        return parkedCars.containsValue(vehicle);
    }

    private boolean hasCarFor(Object token) {
        return this.parkedCars.containsKey(token);
    }

    public Vehicle checkout(Object token) throws NoSuchTokenException {
        if (hasCarFor(token)){
         return parkedCars.remove(token);
        }
        throw  new NoSuchTokenException(token);
    }

    public boolean isFull() {
        return this.parkedCars.size() == capacity;
    }

}
