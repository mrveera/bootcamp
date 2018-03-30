package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/*
Job: Ensures enclosed shape with 4 equal sides and equal angles
*/
public class SquareTest {

    private Rectangle rectangle;

    @Before
    public void setUp() throws Exception {
        rectangle = new Rectangle(20);
    }

    @Test
    public void shouldCalculateForSquareWithSideTwenty() {
        assertThat(rectangle.area(),is(400f));
    }

    @Test
    public void shouldCalculateAreaForSquare() {
        assertThat(new Rectangle(5).area(),is(25f));
    }

    @Test
    public void shouldCalculatePerimeterWithSideTwenty() {
        assertThat(rectangle.perimeter(),is(80f));
    }

    @Test
    public void shouldCalculatePerimeterForSquare() {
        assertThat(new Rectangle(5).area(),is(20f));
    }

}