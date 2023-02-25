package io.github.danielnasciment.mscliente.controller.advice;

public class ErrorResponseDetails {
	
	private String titulo;
	
	private int status;
	
	private String detail;
	
	private long timestamp;

	public ErrorResponseDetails() {
	}
	
	public ErrorResponseDetails(String titulo, int status, String detail, long timestamp) {
		this.titulo = titulo;
		this.status = status;
		this.detail = detail;
		this.timestamp = timestamp;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getStatus() {
		return status;
	}

	public String getDetail() {
		return detail;
	}

	public long getTimestamp() {
		return timestamp;
	}
	
	
	

}
