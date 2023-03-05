package io.github.danielnasciment.mscartoes.exception;

public class CpfNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	public CpfNotFoundException() {
	}
	
	public CpfNotFoundException(String erroMessage) {
		super(erroMessage);
	}
	
}