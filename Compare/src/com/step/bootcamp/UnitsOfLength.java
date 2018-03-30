package com.step.bootcamp;

public enum UnitsOfLength {
    INCH(1),FEET(12);

    private final double conversionFactor;

    UnitsOfLength(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertIntoBaseUnit(double quantity){
        return quantity * conversionFactor;
    }
}
