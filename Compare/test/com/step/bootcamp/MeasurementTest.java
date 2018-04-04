package com.step.bootcamp;

import com.sun.jdi.InvalidTypeException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeasurementTest {


    @Test
    public void twoHunderedTwelveFahernheitShouldbeEqualToOneHunderedCelcius() {
        Measurement oneHunderedCelcius = Measurement.inCelcius(100);
        Measurement twoHunderedTweleveFahrenheit = Measurement.inFahrenheit(212);
        assertEquals(twoHunderedTweleveFahrenheit,oneHunderedCelcius);
    }

}