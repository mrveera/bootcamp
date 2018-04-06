package com.step.bootcamp;

public class NoSuchTokenException extends Exception {
    public NoSuchTokenException(Object token) {
        super("No such tokens existed: "+ token);
    }
}
