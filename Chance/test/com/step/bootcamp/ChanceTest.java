package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
Job : Ensures not occurence of an event
 */
public class ChanceTest {

    private Chance chance;

    @Before
    public void setUp() throws Exception {
        chance = new Chance(0.5d);
    }

    @Test
    public void shouldGiveNotOccurrenceOfAnEventWhenProbabilityIsHalf() {
        assertTrue(chance.not().equals(chance));
    }

    @Test
    public void shouldReturnTrueIfBothObjectsAreSame() {
        assertTrue(chance.equals(chance));
    }

    @Test
    public void shouldReturnFalse() {
        assertFalse(chance.equals(null));
    }

    @Test
    public void shouldRetrnFalseForUnequalObjects() {
        assertFalse(chance.equals(new Chance(0.2d)));
    }

    @Test
    public void shoulReturnFalseForDifferentClasses() {
        Object o = new Object();
        assertFalse((chance.equals(o)));
    }

    @Test
    public void shouldCheckBothAreEqual() {
        Chance chance1 = new Chance(0.5d);
        assertTrue(chance.equals(chance1));
        assertTrue(chance1.equals(chance));
    }

    @Test
    public void shouldCheckAllAreEqual() {
        Chance chance1 = new Chance(0.5d);
        Chance chance2 = new Chance(0.5d);
        assertTrue(chance.equals(chance1));
        assertTrue(chance1.equals(chance2));
        assertTrue(chance2.equals(chance));

    }

    @Test
    public void shouldVerifydoubleAirthmetic() {
        assertEquals(new Chance(0.8d).not(),new Chance(0.2d));
    }

    @Test
    public void shouldGiveIntersectionAsPointTwoFiveWhenProbabilitiesArePointFive() {
        Chance chance1 = new Chance(0.5d);
        assertEquals(chance1.and(chance),new Chance(0.25d));
    }


    @Test
    public void shouldGiveIntersectionWhenTwoProbabilitiesAreGiven() {
        Chance chance1 = new Chance(0.2d);
        assertEquals(chance1.and(chance),new Chance(0.10d));
    }

    @Test
    public void shouldGiveIntersectionForThreeProbabilities() {
        Chance coin = new Chance(0.5);
        Chance dice = new Chance(0.16);
        Chance card = new Chance(0.5);
        assertEquals(coin.and(dice).and(card),new Chance(0.04));
    }

    @Test
    public void shouldGiveUnionOfTwoProbabilitiesWheb() {
        Chance coin1 = new Chance(0.5);
        Chance coin2 = new Chance(0.5);
        assertEquals(coin1.or(coin2),new Chance(0.75));
    }

    @Test
    public void shouldGiveUnionOfTwoProbabilities() {
        Chance chance1 = new Chance(0.2);
        Chance chance2 = new Chance(0.3);
        assertEquals(chance1.or(chance2),new Chance(0.44));
    }



}
