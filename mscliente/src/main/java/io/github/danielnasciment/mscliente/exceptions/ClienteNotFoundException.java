package io.github.danielnasciment.mscliente.exceptions;

public class ClienteNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	public ClienteNotFoundException() {
	}
	
	public ClienteNotFoundException(String erroMessage) {
		super(erroMessage);
	}
	
}