package io.github.danielnasciment.msavaliador.exeptions;

public class CpfNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	
	public CpfNotFoundException() {
	}
	
	public CpfNotFoundException(String erroMessage) {
		super(erroMessage);
	}
	
}
