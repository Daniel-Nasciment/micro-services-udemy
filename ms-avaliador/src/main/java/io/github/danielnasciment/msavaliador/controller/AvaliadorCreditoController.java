package io.github.danielnasciment.msavaliador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.danielnasciment.msavaliador.requestDto.DadosAvaliacaoRequest;
import io.github.danielnasciment.msavaliador.responseDto.SituacaoClienteResponse;
import io.github.danielnasciment.msavaliador.service.AvaliadorService;

@RestController
@RequestMapping(value = "/avaliacoes-credito")
public class AvaliadorCreditoController {
	
	@Autowired
	private AvaliadorService avaliadorService;
	 
	@GetMapping(value = "/situacao-cliente/{cpf}")
	public ResponseEntity<SituacaoClienteResponse> getSituacaoCliente(@PathVariable String cpf) {
		
		return ResponseEntity.ok(avaliadorService.obterSituacao(cpf));
	}

	@PostMapping
	public ResponseEntity<?> avaliarCliente(@RequestBody @Valid DadosAvaliacaoRequest request){
		
		return ResponseEntity.ok(avaliadorService.avaliarCliente(request));
		
	}
	
}
