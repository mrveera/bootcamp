package com.step.bootcamp;

public enum UnitsOfVolume implements Unit {
    LITRE(1),
    GALLON(3.78);

    private final double conversionFactor;

    UnitsOfVolume(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    @Override
    public double toBaseUnit(double quantity) {
        return conversionFactor*quantity;
    }
}
