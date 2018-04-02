package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;


public class CompareTest {
    @Test
    public void shouldGiveTrueForOneFeetAndOneFeet() {
        Unit oneFoot = Unit.inFeet(1);
        Unit expectedFoot = Unit.inFeet(1);
        assertEquals(oneFoot, expectedFoot);
    }

    @Test
    public void shouldGiveTrueForOneFeetAndTwelveInch() {
        Unit oneFoot = Unit.inFeet(1);
        Unit twelveInches = Unit.inInch(12);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void shouldGiveFalseForUnequalFeet() {
        Unit oneFoot = Unit.inFeet(1);
        Unit twoFeet = Unit.inFeet(2);
        assertNotEquals(oneFoot,twoFeet);
    }

    @Test
    public void shouldGiveFalseForOneFootAndSixInch() {
        Unit oneFoot = Unit.inFeet(1);
        Unit sixInches = Unit.inInch(6);
        assertNotEquals(oneFoot,sixInches);
    }

    @Test
    public void shouldGiveTrueForHalfFootAndSixInch() {
        Unit oneFoot = Unit.inFeet(0.5);
        Unit sixInches = Unit.inInch(6);
        assertEquals(oneFoot,sixInches);
    }

    @Test
    public void twoInchShouldBeEqualToFiveCentimeter() {
        Unit fiveCentimeters = Unit.inCentimeters(5);
        Unit twoInches = Unit.inInch(2);
        assertEquals(twoInches,fiveCentimeters);
    }
}
