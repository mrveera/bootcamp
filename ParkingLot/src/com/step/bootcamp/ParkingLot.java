package com.step.bootcamp;

import java.util.HashMap;

public class ParkingLot {
    private final int capacity;
    private HashMap<ParkingToken,Object> parkedCars=new HashMap();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingToken park(Object car) {
        ParkingToken token = new ParkingToken(car.hashCode());
        parkedCars.put(token,car);
        return token;
    }

    private boolean hasCarFor(ParkingToken token) {
        return this.parkedCars.containsKey(token);
    }

    public Object checkout(ParkingToken token) throws NoSuchTokenException {
        if (hasCarFor(token)){
         return parkedCars.remove(token);
        }
        throw  new NoSuchTokenException(token);
    }

    public class NoSuchTokenException extends Exception {
        public NoSuchTokenException(ParkingToken token) {
            super("No such tokens existed: "+ token);
        }
    }
}
