package com.step.bootcamp;

import com.sun.jdi.InvalidTypeException;

import static com.step.bootcamp.Unit.*;

public class AirthmaticMeasurement extends Measurement {


    private AirthmaticMeasurement(double value, Unit unit) {
        super(value, unit);
    }

    public static AirthmaticMeasurement inFeet(double value) {
        return new AirthmaticMeasurement(value, FEET);
    }

    public static AirthmaticMeasurement inInch(double value) {
        return new AirthmaticMeasurement(value, INCH);
    }


    public static AirthmaticMeasurement inCentimeters(double centimeters) {
        return new AirthmaticMeasurement(centimeters,CENTIMETER);
    }


    public static AirthmaticMeasurement inMillimeter(double millimeters) {
        return  new AirthmaticMeasurement(millimeters,MILLI_METER);
    }


    public static AirthmaticMeasurement inLitres(double litres) {
        return new AirthmaticMeasurement(litres,LITRE);
    }

    public static AirthmaticMeasurement inGallon(double gallons) {
        return new AirthmaticMeasurement(gallons,GALLON);
    }

    public static AirthmaticMeasurement inKilograms(double kg) {
        return new AirthmaticMeasurement(kg,KILOGRAM);
    }

    public static AirthmaticMeasurement inGrams(double grams) {
        return new AirthmaticMeasurement(grams,GRAM);
    }

    public static AirthmaticMeasurement inTon(double tons) {
        return new AirthmaticMeasurement(tons,TON);
    }

    public AirthmaticMeasurement add(AirthmaticMeasurement other) throws InvalidTypeException {
        if( !unit.isOfSameBaseUnit(other.unit)  ) {
            throw  new InvalidTypeException("Performing operations with incampatable types");
        }
        double otherUnitInThisUnit = other.unit.toUnit(other.value,unit);
        return new AirthmaticMeasurement(otherUnitInThisUnit+value,unit);
    }

    public AirthmaticMeasurement toUnit(Unit other) throws InvalidTypeException {
        if(!unit.isOfSameBaseUnit(other)) throw new InvalidTypeException("Incompatable types");
        return new AirthmaticMeasurement(unit.toUnit(value,other),other);
    }

}
