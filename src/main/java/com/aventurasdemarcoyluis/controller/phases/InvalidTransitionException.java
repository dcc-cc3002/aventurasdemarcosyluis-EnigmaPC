package com.aventurasdemarcoyluis.controller.phases;

public class InvalidTransitionException extends Exception {
    public InvalidTransitionException(String message) {
        super(message);
    }
}
