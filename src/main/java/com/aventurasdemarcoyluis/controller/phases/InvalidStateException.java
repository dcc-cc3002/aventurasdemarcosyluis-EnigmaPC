package com.aventurasdemarcoyluis.controller.phases;

public class InvalidStateException extends Exception{
    public InvalidStateException(final String message){
        super(message);
    }
}
