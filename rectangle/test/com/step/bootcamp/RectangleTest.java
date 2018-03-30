package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Ensures enclosed shape with 4 corners at right angles
public class RectangleTest {

    private Rectangle rectangle;

    @Before
    public void setUp() throws Exception {
        rectangle = new Rectangle(10, 20);
    }

    @Test
    public void shouldCheckArea() {
        assertEquals(rectangle.area(),200,0);
    }

    @Test
    public void shouldCheckPerimeter() {
        assertEquals(rectangle.perimeter(),60,0);
    }
}