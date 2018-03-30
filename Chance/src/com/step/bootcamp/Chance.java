package com.step.bootcamp;

/*
Job: Understands not occurrence
 of an event
*/

import java.util.Objects;

public class Chance {
    private final double probability;

    public Chance(double probability) {

        this.probability = probability;
    }

    public Chance not() {
        return new Chance((double) Math.round((1-probability)*10)/10);
    }

    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof Chance)) return false;
        Chance c=(Chance) other;
        return  Double.compare(c.probability,probability)==0;
    }

    public Chance and(Chance chance) {
        return new Chance(chance.probability*probability);
    }

    @Override
    public String toString() {
        return "Chance{" +
                "probability=" + probability +
                '}';
    }

    public Chance or(Chance chance) {
//        double sum = (double) chance.probability+probability;
//        double intersection = this.and(chance).probability;
//        return new Chance(sum - intersection) ;
        return  this.not().and(chance.not()).not();
    }
}
