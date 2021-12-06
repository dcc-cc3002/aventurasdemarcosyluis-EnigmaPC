package com.aventurasdemarcoyluis.controller.phases;

/**
 * Estado incorrecto
 */
public class InvalidStateException extends Exception{
    public InvalidStateException(final String message){
        super(message);
    }
}
