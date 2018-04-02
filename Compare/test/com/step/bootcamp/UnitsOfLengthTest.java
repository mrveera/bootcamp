package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitsOfLengthTest  {
    @Test
    public void shouldGiveTwelveInchesForOneFoot() {
        UnitsOfLength oneFoot = UnitsOfLength.FEET;
        double twelveInches = UnitsOfLength.INCH.toBaseUnit(12);
        assertThat(oneFoot.toBaseUnit(1),is(twelveInches));
    }

    @Test
    public void shouldGiveOneFootFortwelveInches() {
        double twelveInches = UnitsOfLength.INCH.toBaseUnit(12);
        UnitsOfLength oneFoot = UnitsOfLength.FEET;
        assertThat(twelveInches, is(oneFoot.toBaseUnit(1)));
    }

    @Test
    public void shouldTwoInchEqalForFiveCentimeters() {
        double twoInches = UnitsOfLength.INCH.toBaseUnit(2);
        double fiveCentimeters = UnitsOfLength.CENTIMETER.toBaseUnit(5);
        assertThat(fiveCentimeters,is(twoInches));
    }

    @Test
    public void oneCMShouldbeEqualToTenMillimeters() {
        double oneCentimeter = UnitsOfLength.CENTIMETER.toBaseUnit(1);
        double tenMillimeters = UnitsOfLength.MILLI_METER.toBaseUnit(10);
        assertThat(oneCentimeter,is(tenMillimeters));
    }
}