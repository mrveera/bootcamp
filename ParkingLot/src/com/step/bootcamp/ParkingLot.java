package com.step.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private final ArrayList<ParkingLotListener> listeners;
    private HashMap<Object, Vehicle> parkedVehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new HashMap(capacity);
        this.listeners= new ArrayList<>();
    }

    public Object park(Vehicle vehicle) throws UnableToParkException {
        if (isAlreadyParked(vehicle)) {
            throw new UnableToParkException("The vehicle you are trying to park is already parked");
        }
        if (isFull()) {
            throw new UnableToParkException("Parking lot is full try after sometime ...");
        }
        Object token = new Object();
        parkedVehicles.put(token, vehicle);
        if(isFull()){
            broadcastFull();
        }
        return token;
    }

    private void broadcastFull() {
        for (ParkingLotListener listener : listeners) {
            listener.full();
        }
    }

    private boolean isAlreadyParked(Vehicle vehicle) {
        return parkedVehicles.containsValue(vehicle);
    }

    private boolean hasCarFor(Object token) {
        return this.parkedVehicles.containsKey(token);
    }

    public Vehicle checkout(Object token) throws NoSuchTokenException {
        if (hasCarFor(token)) {
            if(isFull()) broadcastHasSpace();
            Vehicle vehicle = parkedVehicles.remove(token);
            return vehicle;
        }
        throw new NoSuchTokenException(token);
    }

    private void broadcastHasSpace() {
        for (ParkingLotListener listener : listeners) {
            listener.hasSpace();
        }
    }

    public boolean isFull() {
        return this.parkedVehicles.size() == capacity;
    }

    public void addListener(ParkingLotListener foo) {
        listeners.add(foo);
    }
}
