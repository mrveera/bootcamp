package com.step.bootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MeasurementTest {
    @Test
    public void shouldGiveTrueForOneFeetAndOneFeet() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement expectedFoot = Measurement.inFeet(1);
        assertEquals(oneFoot, expectedFoot);
    }

    @Test
    public void shouldGiveTrueForOneFeetAndTwelveInch() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement twelveInches = Measurement.inInch(12);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void shouldGiveFalseForUnequalFeet() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement twoFeet = Measurement.inFeet(2);
        assertNotEquals(oneFoot,twoFeet);
    }

    @Test
    public void shouldGiveFalseForOneFootAndSixInch() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement sixInches = Measurement.inInch(6);
        assertNotEquals(oneFoot,sixInches);
    }

    @Test
    public void shouldGiveTrueForHalfFootAndSixInch() {
        Measurement oneFoot = Measurement.inFeet(0.5);
        Measurement sixInches = Measurement.inInch(6);
        assertEquals(oneFoot,sixInches);
    }

    @Test
    public void twoInchShouldBeEqualToFiveCentimeter() {
        Measurement fiveCentimeters = Measurement.inCentimeters(5);
        Measurement twoInches = Measurement.inInch(2);
        assertEquals(twoInches,fiveCentimeters);
    }

    @Test
    public void fourInchesShouldBeEqualToTenCentimeter() {
        Measurement tenCentimeter = Measurement.inCentimeters(10.15);
        Measurement fourInch = Measurement.inInch(4);
        assertEquals(fourInch,tenCentimeter);
    }

    @Test
    public void tenMillimetersShouldbeEqualToOneCentimeter() {
        Measurement oneCentimeter = Measurement.inCentimeters(1);
        Measurement tenMillimeters = Measurement.inMillimeter(10);
        assertEquals(oneCentimeter,tenMillimeters);
    }

    @Test
    public void oneGallonShouldbeEqualToThreePointSevenEightLitres() {
        Measurement threePointSevenEightLitres = Measurement.inLitres(3.78);
        Measurement oneGallon = Measurement.inGallon(1);
        assertEquals(oneGallon,threePointSevenEightLitres);
    }
}
