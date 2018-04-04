package com.step.bootcamp;

import com.sun.jdi.InvalidTypeException;

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
        Measurement other = (Measurement) o;
        double valueInThisUnit = other.unit.toUnit(other.value,unit);
        return compareDouble(valueInThisUnit,value) && unit.isOfSameBaseUnit(other.unit);
    }

    private boolean compareDouble(double valueInThisUnit, double value) {
        return valueInThisUnit-value == 0;
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
        if( !unit.isOfSameBaseUnit(other.unit)  ) {
            throw  new InvalidTypeException("Performing operations with incampatable types");
        }
        double otherUnitInThisUnit = other.unit.toUnit(other.value,unit);
        return new Measurement(otherUnitInThisUnit+value,unit);
    }


}
