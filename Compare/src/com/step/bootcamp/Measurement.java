package com.step.bootcamp;

import com.sun.jdi.InvalidTypeException;

import java.util.Objects;

import static com.step.bootcamp.Unit.*;

public class Measurement {
    private final double value;
    private final Unit unit;


    private Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Measurement inFeet(double value) {
        return new Measurement(value, FEET);
    }

    public static Measurement inInch(double value) {
        return new Measurement(value, INCH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement length = (Measurement) o;
        double valueInBaseunit = unit.toBaseUnitValue(value);
        double otherValueInBaseUnit = length.unit.toBaseUnitValue(length.value);
        return Double.compare(valueInBaseunit, otherValueInBaseUnit) == 0 && unit.isOfSameBaseUnit(length.unit);
    }

    @Override
    public int hashCode() {
        return unit.hash(value);
    }

    public static Measurement inCentimeters(double centimeters) {
        return new Measurement(centimeters,CENTIMETER);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static Measurement inMillimeter(double millimeters) {
        return  new Measurement(millimeters,MILLI_METER);
    }


    public static Measurement inLitres(double litres) {
        return new Measurement(litres,LITRE);
    }

    public static Measurement inGallon(double gallons) {
        return new Measurement(gallons,GALLON);
    }

    public static Measurement inKilograms(double kg) {
        return new Measurement(kg,KILOGRAM);
    }

    public static Measurement inGrams(double grams) {
        return new Measurement(grams,GRAM);
    }

    public static Measurement inTon(double tons) {
        return new Measurement(tons,TON);
    }

    public Measurement add(Measurement other) throws InvalidTypeException {
        if(!unit.isOfSameBaseUnit(other.unit)) throw  new InvalidTypeException("Performing operations with incampatable types");
        double result=unit.toBaseUnitValue(value)+other.unit.toBaseUnitValue(other.value);
        return Measurement.inInch(result);
    }
}
