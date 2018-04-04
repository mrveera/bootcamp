package com.step.bootcamp;

import com.sun.jdi.InvalidTypeException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class AirthmaticMeasurementTest {
    @Test
    public void shouldGiveTrueForOneFeetAndOneFeet() {
        AirthmaticMeasurement oneFoot = AirthmaticMeasurement.inFeet(1);
        AirthmaticMeasurement expectedFoot = AirthmaticMeasurement.inFeet(1);
        assertEquals(oneFoot, expectedFoot);
        assertEquals(oneFoot.hashCode(),expectedFoot.hashCode());
    }

    @Test
    public void shouldGiveTrueForOneFeetAndTwelveInch() {
        AirthmaticMeasurement oneFoot = AirthmaticMeasurement.inFeet(1);
        AirthmaticMeasurement twelveInches = AirthmaticMeasurement.inInch(12);
        assertEquals(oneFoot, twelveInches);
        assertEquals(oneFoot.hashCode(),twelveInches.hashCode());
    }

    @Test
    public void shouldGiveFalseForUnequalFeet() {
        AirthmaticMeasurement oneFoot = AirthmaticMeasurement.inFeet(1);
        AirthmaticMeasurement twoFeet = AirthmaticMeasurement.inFeet(2);
        assertNotEquals(twoFeet,oneFoot);
        assertNotEquals(oneFoot.hashCode(),twoFeet.hashCode());
    }

    @Test
    public void shouldGiveFalseForOneFootAndSixInch() {
        AirthmaticMeasurement oneFoot = AirthmaticMeasurement.inFeet(1);
        AirthmaticMeasurement sixInches = AirthmaticMeasurement.inInch(6);
        assertNotEquals(oneFoot,sixInches);
    }




    @Test
    public void twoInchShouldBeEqualToFiveCentimeter() {
        AirthmaticMeasurement fiveCentimeters = AirthmaticMeasurement.inCentimeters(5);
        AirthmaticMeasurement twoInches = AirthmaticMeasurement.inInch(2);
        assertEquals(twoInches,fiveCentimeters);
    }

    @Test
    public void fourInchesShouldBeEqualToTenCentimeter() {
        AirthmaticMeasurement tenCentimeter = AirthmaticMeasurement.inCentimeters(10);
        AirthmaticMeasurement fourInch = AirthmaticMeasurement.inInch(4);
        assertEquals(fourInch,tenCentimeter);
    }

    @Test
    public void tenMillimetersShouldBeEqualToOneCentimeter() {
        AirthmaticMeasurement oneCentimeter = AirthmaticMeasurement.inCentimeters(1);
        AirthmaticMeasurement tenMillimeters = AirthmaticMeasurement.inMillimeter(10);
        assertEquals(oneCentimeter,tenMillimeters);
    }

    @Test
    public void oneGallonShouldBeEqualToThreePointSevenEightLitres() {
        AirthmaticMeasurement threePointSevenEightLitres = AirthmaticMeasurement.inLitres(3.78);
        AirthmaticMeasurement oneGallon = AirthmaticMeasurement.inGallon(1);
        assertEquals(oneGallon,threePointSevenEightLitres);
    }

    @Test
    public void oneGallonShouldNotBeEqualToOneInch() {
        AirthmaticMeasurement oneInch = AirthmaticMeasurement.inInch(1);
        AirthmaticMeasurement oneLitre = AirthmaticMeasurement.inLitres(1);
        assertNotEquals(oneLitre,oneInch);
    }

    @Test
    public void oneKgShouldBeEqualToThousandGrams() {
        AirthmaticMeasurement oneKiloGram = AirthmaticMeasurement.inKilograms(1);
        AirthmaticMeasurement thousandGrams = AirthmaticMeasurement.inGrams(1000);
        assertEquals(oneKiloGram,thousandGrams);
    }

    @Test
    public void oneTonShouldBeEqualToThousandKg() {
        AirthmaticMeasurement oneTon = AirthmaticMeasurement.inTon(1);
        AirthmaticMeasurement thousandKg = AirthmaticMeasurement.inKilograms(1000);
        assertEquals(oneTon,thousandKg);
    }

    @Test
    public void addingTwo2InchesShouldbeEqualTo4Inches() throws InvalidTypeException {
        AirthmaticMeasurement twoInches = AirthmaticMeasurement.inInch(2);
        AirthmaticMeasurement anotherTwoInches = AirthmaticMeasurement.inInch(2);
        AirthmaticMeasurement fourInches = AirthmaticMeasurement.inInch(4);
        AirthmaticMeasurement actual = twoInches.add(anotherTwoInches);
        assertEquals(actual,fourInches);
    }

    @Test(expected = InvalidTypeException.class)
    public void shouldNotAddLitreAndInches() throws InvalidTypeException {
        AirthmaticMeasurement twoInches = AirthmaticMeasurement.inInch(2);
        AirthmaticMeasurement twoLitres = AirthmaticMeasurement.inLitres(2);
        AirthmaticMeasurement nothing = twoLitres.add(twoInches);
    }

    @Test
    public void oneKgShouldCovertToThousandGrams() throws InvalidTypeException {
        AirthmaticMeasurement oneKg = AirthmaticMeasurement.inKilograms(1);
        AirthmaticMeasurement thousandGrams = AirthmaticMeasurement.inGrams(1000);
        assertEquals(oneKg.toUnit(Unit.GRAM),thousandGrams);
    }

    @Test
    public void addingOf2InchesAnd2Point5CentimetersShouldbeEqualTo3Inches() throws InvalidTypeException {
        AirthmaticMeasurement twoInches = AirthmaticMeasurement.inInch(2);
        AirthmaticMeasurement twoPoint5cm = AirthmaticMeasurement.inCentimeters(2.5);
        AirthmaticMeasurement threeInches = AirthmaticMeasurement.inInch(3);
        AirthmaticMeasurement actual = twoInches.add(twoPoint5cm);
        assertEquals(actual,threeInches);
        assertEquals(actual.toString(),threeInches.toString());
    }



    @Test
    public void addingOneGallonAndOneLitreShouldbeEqualToFourPointSevenEight() throws InvalidTypeException {
        AirthmaticMeasurement oneGallon = AirthmaticMeasurement.inGallon(1);
        AirthmaticMeasurement oneLitre = AirthmaticMeasurement.inLitres(1);
        AirthmaticMeasurement fourPointSevenEight = AirthmaticMeasurement.inLitres(4.8);
        AirthmaticMeasurement actual = oneLitre.add(oneGallon);
        assertEquals(fourPointSevenEight,actual);
    }

}
