package com.aventurasdemarcoyluis.controller;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Para el testeo de manera silenciosa. Se inicializa un
 * PrintStream silencioso de la siguiente manera:
 * 		new PrintStream(new NullOutputStream())
 */
public class NullOutputStream extends OutputStream {

	public NullOutputStream() {
		super();
	}

	/**
	 * Implementación nula del método abstracto heredado
	 */
	public void write(int b) throws IOException { }
}
