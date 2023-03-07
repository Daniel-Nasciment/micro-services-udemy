package io.github.danielnasciment.msavaliador.responseDto;

import java.math.BigDecimal;

import io.github.danielnasciment.msavaliador.domain.enumerateds.BandeiraCartao;


public class CartaoResponse {
	
	private String nome;
	private BandeiraCartao bandeira;
	private BigDecimal renda;
	private BigDecimal limiteBasico;

	public String getNome() {
		return nome;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public BigDecimal getLimiteBasico() {
		return limiteBasico;
	}

}
