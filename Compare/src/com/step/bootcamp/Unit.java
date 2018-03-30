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
        return Double.compare(unit.convertIntoBaseUnit(value),length.unit.convertIntoBaseUnit(length.value)) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
