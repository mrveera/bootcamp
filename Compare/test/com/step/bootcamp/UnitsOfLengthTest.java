package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitsOfLengthTest {
    @Test
    public void shouldGiveTwelveInchesForOneFoot() {
        UnitsOfLength oneFoot = UnitsOfLength.FEET;
        double twelveInches = UnitsOfLength.INCH.convertIntoBaseUnit(12);
        assertThat(oneFoot.convertIntoBaseUnit(1),is(twelveInches));
    }

    @Test
    public void shouldGiveOneFootFortwelveInches() {
        double twelveInches = UnitsOfLength.INCH.convertIntoBaseUnit(12);
        UnitsOfLength oneFoot = UnitsOfLength.FEET;
        assertThat(twelveInches, is(oneFoot.convertIntoBaseUnit(1)));
    }
}