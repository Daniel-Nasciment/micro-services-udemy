package io.github.danielnasciment.mscartoes.controller.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.github.danielnasciment.mscartoes.exception.CpfNotFoundException;
import io.github.danielnasciment.mscartoes.exception.RendaInvalidaException;
import io.github.danielnasciment.mscartoes.exception.SolicitacaoCartaoException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	
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
	
	@ExceptionHandler(RendaInvalidaException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> handlerRendaInvalidaException(RendaInvalidaException ex){
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDetails(
				"Por favor, informe a renda apenas com números!", 
				HttpStatus.BAD_REQUEST.value(), 
				Arrays.asList(ex.getMessage()),
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
	
	@ExceptionHandler(SolicitacaoCartaoException.class)
	public ResponseEntity<?> solicitacaoCartaoException(SolicitacaoCartaoException ex){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDetails(
				"Erro ao solicitar emissao do cartao!",
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				Arrays.asList(ex.getMessage()),
				new Date().getTime()));
	}
	
}
