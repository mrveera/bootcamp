package com.step.bootcamp;

import java.util.Objects;

public class Measurement {
    private final double value;
    private final Unit unit;


    private Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Measurement inFeet(double value) {
        return new Measurement(value, UnitsOfLength.FEET);
    }

    public static Measurement inInch(double value) {
        return new Measurement(value, UnitsOfLength.INCH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement length = (Measurement) o;
        double inBaseunit = unit.toBaseUnit(value);
        double otherInBaseUnit = length.unit.toBaseUnit(length.value);
//        return Double.compare(inBaseunit, otherInBaseUnit) == 0 && unit.getStandardUnit()==length.unit.getStandardUnit();
        return Double.compare(inBaseunit, otherInBaseUnit) == 0 && unit.isOfSameBaseUnit(length.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static Measurement inCentimeters(double centimeters) {
        return new Measurement(centimeters,UnitsOfLength.CENTIMETER);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static Measurement inMillimeter(double millimeters) {
        return  new Measurement(millimeters,UnitsOfLength.MILLI_METER);
    }


    public static Measurement inLitres(double litres) {
        return new Measurement(litres,UnitsOfVolume.LITRE);
    }

    public static Measurement inGallon(double gallons) {
        return new Measurement(gallons,UnitsOfVolume.GALLON);
    }

    public static Measurement inKilograms(double kg) {
        return new Measurement(kg,UnitsOfWeight.KILOGRAM);
    }

    public static Measurement inGrams(double grams) {
        return new Measurement(grams,UnitsOfWeight.GRAM);
    }

    public static Measurement inTon(double tons) {
        return new Measurement(tons,UnitsOfWeight.TON);
    }
}
