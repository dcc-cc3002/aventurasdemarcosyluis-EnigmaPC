package com.aventurasdemarcoyluis.controller.phases;

/**
 * Transición de fase fallida
 */
public class InvalidTransitionException extends Exception {
    public InvalidTransitionException(String message) {
        super(message);
    }
}
