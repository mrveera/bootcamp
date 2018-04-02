package com.step.bootcamp;

public enum UnitsOfWeight implements Unit{
GRAM(1),
    KILOGRAM(1000), TON(1000*1000);

    private final double conversionFactor;

    UnitsOfWeight(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double toBaseUnit(double quantity) {
        return this.conversionFactor * quantity;
    }

    @Override
    public boolean isOfSameBaseUnit(Unit unit) {
        return this.getClass()==unit.getClass();
    }
}
