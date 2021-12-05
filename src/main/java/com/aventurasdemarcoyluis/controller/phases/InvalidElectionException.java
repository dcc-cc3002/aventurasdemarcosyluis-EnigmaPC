package com.aventurasdemarcoyluis.controller.phases;

/**
 * Elección incorrecta
 */
public class InvalidElectionException extends Exception{
    public InvalidElectionException(final String message){
        super(message);
    }
}
