package io.github.danielnasciment.msavaliador.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;

import feign.Request.HttpMethod;

public class ErrorResponseDetailsClient {

	private HttpMethod method;

	private HttpStatus status;

	private String url;

	private long timestamp = new Date().getTime();

	public ErrorResponseDetailsClient() {
	}

	public ErrorResponseDetailsClient(HttpMethod method, HttpStatus status, String url) {
		this.method = method;
		this.status = status;
		this.url = url;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getUrl() {
		return url;
	}

	public long getTimestamp() {
		return timestamp;
	}

}
