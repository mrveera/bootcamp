package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitsOfVolumeTest {
    @Test
    public void oneGallonShouldbeEqualToThreePointSevenEightLitres() {
        double threePointSevenEightLitres = UnitsOfVolume.LITRE.toBaseUnit(3.78);
        double oneGallon = UnitsOfVolume.GALLON.toBaseUnit(1);
        assertThat(threePointSevenEightLitres,is(oneGallon));
    }
}
