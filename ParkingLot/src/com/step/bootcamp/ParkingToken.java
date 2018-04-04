package com.step.bootcamp;

import java.util.Objects;

public class ParkingToken {
    private final int carID;

    public ParkingToken(int carID) {
        this.carID = carID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingToken token = (ParkingToken) o;
        return carID == token.carID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(carID);
    }
}
