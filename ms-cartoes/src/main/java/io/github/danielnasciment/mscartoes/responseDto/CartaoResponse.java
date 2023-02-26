package io.github.danielnasciment.mscartoes.responseDto;

import java.math.BigDecimal;

import io.github.danielnasciment.mscartoes.domain.Cartao;
import io.github.danielnasciment.mscartoes.domain.enumerateds.BandeiraCartao;

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

	public CartaoResponse toResponse(Cartao cartao) {

		this.nome = cartao.getNome();
		this.bandeira = cartao.getBandeira();
		this.renda = cartao.getRenda();
		this.limiteBasico = cartao.getLimiteBasico();

		return this;

	}

}
