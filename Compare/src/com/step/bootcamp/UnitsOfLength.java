package com.step.bootcamp;

public enum UnitsOfLength implements Unit {
    INCH(1),FEET(12),
    CENTIMETER(0.393701),
    MILLI_METER(0.0393701);

    private final double conversionFactor;

    UnitsOfLength(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toBaseUnit(double quantity) {
        return Math.round((quantity * conversionFactor)*10)/10;
    }

}
