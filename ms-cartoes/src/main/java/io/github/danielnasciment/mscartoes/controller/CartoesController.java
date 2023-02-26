package io.github.danielnasciment.mscartoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danielnasciment.mscartoes.requestDto.CartaoRequest;
import io.github.danielnasciment.mscartoes.service.CartaoService;

@RestController
@RequestMapping(value = "/cartoes")
public class CartoesController {
	

	@Autowired
	private CartaoService cartaoService;
	
	
	@PostMapping
	public ResponseEntity<?> cadastrarCartao(@RequestBody @Valid CartaoRequest request) {
		
		cartaoService.salvarNovoCartao(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	


}
