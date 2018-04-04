package com.step.bootcamp;

import org.junit.Test;

import static com.step.bootcamp.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class UnitTest {

    @Test
    public void oneFootShouldBeEqualToTweleveInches() {
        assertThat(FEET.toUnit(1, INCH),is(12d));
    }


    @Test
    public void shouldTwoInchEqalForFiveCentimeters() {
        assertThat(INCH.toUnit(2,CENTIMETER),is(5d));
    }

    @Test
    public void oneCMShouldBeEqualToTenMillimeters() {
        assertThat(CENTIMETER.toUnit(1,MILLI_METER),is(10d));
    }

    @Test
    public void oneGallonShouldBeEqualToThreePointSevenEightLitres() {
        assertThat(GALLON.toUnit(1,LITRE),is(3.78));
    }

    @Test
    public void oneKgShouldBeEqualToOneKg() {
        assertThat(KILOGRAM.toUnit(1,KILOGRAM),is(1d));
    }


    @Test
    public void oneTonShouldBeEqualToThousandKg() {
        assertThat(TON.toUnit(1,KILOGRAM),is(1000d));
    }

    @Test
    public void tonShouldNotBeOfSameTypeAsFeet() {
        assertFalse(TON.isOfSameBaseUnit(FEET));
    }

    @Test
    public void litreShouldNotOfSameTypeAsFeet() {
        assertFalse(LITRE.isOfSameBaseUnit(FEET));
    }

    @Test
    public void shouldConvertOneKgToThousandGrams() {
        assertEquals(KILOGRAM.toUnit(1, GRAM),1000,0);
    }
}

