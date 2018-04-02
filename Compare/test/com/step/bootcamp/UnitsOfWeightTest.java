package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitsOfWeightTest {
    @Test
    public void oneKgShouldbeEqualToOneKg() {
        double oneKiloGram = UnitsOfWeight.KILOGRAM.toBaseUnit(1);
        double anotherKiloGram = UnitsOfWeight.KILOGRAM.toBaseUnit(1);
        assertThat(oneKiloGram,is(anotherKiloGram));
    }

    @Test
    public void oneKgShouldbeEqualToThousandGrams() {
        double thousandGrams = UnitsOfWeight.GRAM.toBaseUnit(1000);
        double oneKiloGram = UnitsOfWeight.KILOGRAM.toBaseUnit(1);
        assertThat(thousandGrams,is(oneKiloGram));

    }

    @Test
    public void oneTonShouldbeEqualToThousandKg() {
        double thousandKg = UnitsOfWeight.KILOGRAM.toBaseUnit(1000);
        double oneTon = UnitsOfWeight.TON.toBaseUnit(1);
        assertThat(thousandKg,is(oneTon));
    }
}
