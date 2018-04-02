package com.step.bootcamp;

import java.util.Objects;

public class Unit {
    private final double value;
    private final UnitsOfLength unit;


    private Unit(double value, UnitsOfLength unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Unit inFeet(double value) {
        return new Unit(value, UnitsOfLength.FEET);
    }

    public static Unit inInch(double value) {
        return new Unit(value, UnitsOfLength.INCH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit length = (Unit) o;
        double inInches = unit.convertIntoBaseUnit(value);
        double otherUnitInInches = length.unit.convertIntoBaseUnit(length.value);
        return Double.compare(inInches, otherUnitInInches) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static Unit inCentimeters(double centimeters) {
        return new Unit(centimeters,UnitsOfLength.CENTIMETER);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
