package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class UnitTest {

    @Test
    public void shouldGiveOneFootFortwelveInches() {
        double twelveInches = Unit.INCH.toBaseUnitValue(12);
        Unit oneFoot = Unit.FEET;
        assertThat(twelveInches, is(oneFoot.toBaseUnitValue(1)));
    }

    @Test
    public void shouldGiveTwelveInchesForOneFoot() {
        Unit oneFoot = Unit.FEET;
        double twelveInches = Unit.INCH.toBaseUnitValue(12);
        assertThat(oneFoot.toBaseUnitValue(1), is(twelveInches));
    }

    @Test
    public void shouldTwoInchEqalForFiveCentimeters() {
        double twoInches = Unit.INCH.toBaseUnitValue(2);
        double fiveCentimeters = Unit.CENTIMETER.toBaseUnitValue(5);
        assertThat(fiveCentimeters, is(twoInches));
    }

    @Test
    public void oneCMShouldBeEqualToTenMillimeters() {
        double oneCentimeter = Unit.CENTIMETER.toBaseUnitValue(1);
        double tenMillimeters = Unit.MILLI_METER.toBaseUnitValue(10);
        assertThat(oneCentimeter, is(tenMillimeters));
    }

    @Test
    public void oneGallonShouldBeEqualToThreePointSevenEightLitres() {
        double threePointSevenEightLitres = Unit.LITRE.toBaseUnitValue(3.78);
        double oneGallon = Unit.GALLON.toBaseUnitValue(1);
        assertThat(threePointSevenEightLitres, is(oneGallon));
    }

    @Test
    public void oneKgShouldBeEqualToOneKg() {
        double oneKiloGram = Unit.KILOGRAM.toBaseUnitValue(1);
        double anotherKiloGram = Unit.KILOGRAM.toBaseUnitValue(1);
        assertThat(oneKiloGram, is(anotherKiloGram));
    }

    @Test
    public void oneKgShouldBeEqualToThousandGrams() {
        double thousandGrams = Unit.GRAM.toBaseUnitValue(1000);
        double oneKiloGram = Unit.KILOGRAM.toBaseUnitValue(1);
        assertThat(thousandGrams, is(oneKiloGram));

    }

    @Test
    public void oneTonShouldBeEqualToThousandKg() {
        double thousandKg = Unit.KILOGRAM.toBaseUnitValue(1000);
        double oneTon = Unit.TON.toBaseUnitValue(1);
        assertThat(thousandKg, is(oneTon));
    }

    @Test
    public void tonShouldNotBeOfSameTypeAsFeet() {
        Unit ton = Unit.TON;
        Unit feet = Unit.FEET;
        assertFalse(ton.isOfSameBaseUnit(feet));
    }

    @Test
    public void litreShouldNotOfSameTypeAsFeet() {
        Unit litre = Unit.LITRE;
        Unit feet = Unit.FEET;
        assertFalse(litre.isOfSameBaseUnit(feet));
    }
}

