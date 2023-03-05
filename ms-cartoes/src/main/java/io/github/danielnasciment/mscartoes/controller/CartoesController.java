package io.github.danielnasciment.mscartoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danielnasciment.mscartoes.exception.CpfNotFoundException;
import io.github.danielnasciment.mscartoes.exception.RendaInvalidaException;
import io.github.danielnasciment.mscartoes.requestDto.CartaoRequest;
import io.github.danielnasciment.mscartoes.responseDto.CartaoResponse;
import io.github.danielnasciment.mscartoes.service.CartaoService;
import io.github.danielnasciment.mscartoes.service.ClienteLimiteService;

@RestController
@RequestMapping(value = "/cartoes")
public class CartoesController {
	

	private static final String REGEX_ONLY_NUMERIC_VALUES = "[0-9]+";
	
	@Autowired
	private CartaoService cartaoService;
	
	@Autowired
	private ClienteLimiteService clienteService;
	
	
	@PostMapping
	public ResponseEntity<?> cadastrarCartao(@RequestBody @Valid CartaoRequest request) {
		
		cartaoService.salvarNovoCartao(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@GetMapping(value = "/{renda}")
	public ResponseEntity<?> getCartoesPorRenda(@PathVariable String renda) throws RendaInvalidaException {
		
		if(!renda.matches(REGEX_ONLY_NUMERIC_VALUES)) {
			throw new RendaInvalidaException();
		}
		
		List<CartaoResponse> cartoes = cartaoService.getCartoesRendaMenorIgual(Long.valueOf(renda));
		
		return ResponseEntity.ok(cartoes);
	}
	
	@GetMapping(value = "/listCartoes/{cpf}")
	public ResponseEntity<?> listarCartoesPorCpf(@PathVariable String cpf) throws CpfNotFoundException {
		
		return ResponseEntity.ok(clienteService.listCartoesByCpf(cpf));
		
	}



}
