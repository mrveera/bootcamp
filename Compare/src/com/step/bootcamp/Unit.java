package com.step.bootcamp;

import java.util.Objects;

import static com.step.bootcamp.MeasurementType.*;

public enum Unit {
    INCH(1, LENGTH),FEET(12,LENGTH), CENTIMETER(0.4,LENGTH) , MILLI_METER(0.04,LENGTH),
    LITRE(1,VOLUME) , GALLON(3.78,VOLUME),
    GRAM(1,WEIGHT), KILOGRAM(1000,WEIGHT), TON(1000*1000,WEIGHT),
    CELCIUS(33.8,TEMPARATURE){
        @Override
        public double toUnit(double value, Unit other) {
            return (9/5*value+32);
        }
    },FAHRENHEIT(1,TEMPARATURE){
        @Override
        public double toUnit(double value, Unit other) {
            return (value-32)*5/9;
        }
        
    };

    private final double valueInBaseUnit;
    private final MeasurementType type;

    Unit(double valueInBaseUnit,MeasurementType type) {
        this.valueInBaseUnit = valueInBaseUnit;
        this.type = type;
    }

    public double toUnit(double value, Unit other) {
        return (value*valueInBaseUnit) /other.valueInBaseUnit;
    }

    public boolean isOfSameBaseUnit(Unit unit) {
        return type == unit.type;
    }

    public int hash(double value) {
        return Objects.hash((double) (Math.round((value * valueInBaseUnit) * 10) / 10));
    }

}


