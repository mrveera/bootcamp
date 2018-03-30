package com.step.bootcamp;

// Understands enclosed shape with 4 corners at right angles
public class Rectangle {

    private final float length;
    private final float breadth;

    public Rectangle(float length, float breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public Rectangle(float side) {
        this(side,side);
    }


    public float area() {
        return length*breadth;
    }

    public float perimeter() {
        return 2*(length+breadth);
    }
}
