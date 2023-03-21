package io.github.danielnasciment.mscartoes.exception;

public class SolicitacaoCartaoException extends Exception {
	private static final long serialVersionUID = 1L;

	
	public SolicitacaoCartaoException(String message, Exception ex) {
		super(message, ex);
	}
	
}
