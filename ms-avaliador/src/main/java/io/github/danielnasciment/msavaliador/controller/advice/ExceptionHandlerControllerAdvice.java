package io.github.danielnasciment.msavaliador.controller.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import feign.FeignException;
import feign.RetryableException;
import io.github.danielnasciment.msavaliador.exeptions.CpfNotFoundException;
import io.github.danielnasciment.msavaliador.exeptions.SolicitacaoCartaoException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		List<String> fieldsError = new ArrayList<>();
		
		ex.getFieldErrors().forEach(f -> fieldsError.add("PARAMETRO: [" + f.getField() + "] Mensagem: [" + f.getDefaultMessage() + "]"));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDetails(
				"Por favor, verifique se todos os campos foram preenchidos corretamente!", 
				HttpStatus.BAD_REQUEST.value(), 
				fieldsError,
				new Date().getTime()));
	}
	
	@ExceptionHandler(CpfNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<?> handlerClienteNotFoundException(CpfNotFoundException ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDetails(
				"Cliente nao encontrado!", 
				HttpStatus.NOT_FOUND.value(), 
				Arrays.asList(ex.getMessage()),
				new Date().getTime()));
	}
	
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<?> handlerFeignException(FeignException ex){
		
		LOGGER.error("[Method: {} - Status: {} - URL: {}]", ex.request().httpMethod(), ex.status(), ex.request().url());
		
		return ResponseEntity.status(HttpStatus.valueOf(ex.status())).body(new ErrorResponseDetailsClient(
				ex.request().httpMethod(), 
				HttpStatus.valueOf(ex.status()), 
				ex.request().url()
				));
	}
	
	@ExceptionHandler(RetryableException.class)
	public ResponseEntity<?> handlerClienteNotFoundException(RetryableException ex){
		
		LOGGER.error("[Method: {} - Status: {} - URL: {}]", ex.request().httpMethod(), ex.status(), ex.request().url());
		
		return ResponseEntity.status(HttpStatus.valueOf(ex.status())).body(new ErrorResponseDetailsClient(
				ex.request().httpMethod(), 
				HttpStatus.valueOf(ex.status()), 
				ex.request().url()));
	}
	
	@ExceptionHandler(SolicitacaoCartaoException.class)
	public ResponseEntity<?> solicitacaoCartaoException(SolicitacaoCartaoException ex){
		
		LOGGER.error("Solicitaçao Cartao exception: ", ex.getCause().getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDetails(
				"Erro ao solicitar emissao do cartao!",
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				Arrays.asList(ex.getMessage()),
				new Date().getTime()));
	}
	
}
