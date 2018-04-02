package com.step.bootcamp;

public enum UnitsOfLength {
    INCH(1),FEET(12),CENTIMETER(0.393701);

    private final double conversionFactor;

    UnitsOfLength(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertIntoBaseUnit(double quantity){
        return Math.round((quantity * conversionFactor)*10)/10;
    }
}
