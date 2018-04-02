package com.step.bootcamp;

import static com.step.bootcamp.MeasurementType.*;

public enum Unit {
    INCH(1, LENGTH),FEET(12,LENGTH), CENTIMETER(0.393701,LENGTH) , MILLI_METER(0.0393701,LENGTH),
    LITRE(1,VOLUME) , GALLON(3.78,VOLUME),
    GRAM(1,WEIGHT), KILOGRAM(1000,WEIGHT), TON(1000*1000,WEIGHT);

    private final double conversionFactor;
    private final MeasurementType type;

    Unit(double conversionFactor,MeasurementType type) {
        this.conversionFactor = conversionFactor;
        this.type = type;
    }


    public double toBaseUnitValue(double quantity) {
        return Math.round((quantity * conversionFactor)*10)/10;
    }

    public boolean isOfSameBaseUnit(Unit unit) {
        return type == unit.type;
    }

}
