package io.github.danielnasciment.msavaliador.requestDto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DadosAvaliacaoRequest {

	@NotBlank
	private String cpf;
	
	@NotNull
	private BigDecimal renda;
	
	public String getCpf() {
		return cpf;
	}
	
	public BigDecimal getRenda() {
		return renda;
	}
	
}
