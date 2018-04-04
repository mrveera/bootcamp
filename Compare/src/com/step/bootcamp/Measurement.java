package com.step.bootcamp;

import com.sun.jdi.InvalidTypeException;

import static com.step.bootcamp.Unit.*;

public class Measurement {
    protected final double value;
    protected final Unit unit;


    protected Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        return unit.hash(value);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
    public static Measurement inCelcius(double celcius) {
        return new Measurement(celcius,CELCIUS);
    }

    public static Measurement inFahrenheit(double fahrenheits) {
        return new Measurement(fahrenheits,FAHRENHEIT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement other = (Measurement) o;
        double valueInThisUnit = other.unit.toUnit(other.value,unit);
        return compareDouble(valueInThisUnit,value) && unit.isOfSameBaseUnit(other.unit);
    }

    private boolean compareDouble(double valueInThisUnit, double value) {
        return Math.round(valueInThisUnit*10)/10==Math.round(value*10)/10;
    }
}
