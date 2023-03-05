package io.github.danielnasciment.mscartoes.requestDto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.github.danielnasciment.mscartoes.domain.Cartao;
import io.github.danielnasciment.mscartoes.domain.enumerateds.BandeiraCartao;

public class CartaoRequest {

	@NotBlank
	private String nome;
	
	@NotNull
	private BandeiraCartao bandeira;
	
	@NotNull
	private BigDecimal renda;
	
	@NotNull
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

	public Cartao toModel() {
		return new Cartao(this.nome, this.bandeira, this.renda, this.limiteBasico);
	}

}
