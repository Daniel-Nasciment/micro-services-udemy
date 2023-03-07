package io.github.danielnasciment.msavaliador.responseDto;

import java.math.BigDecimal;

import io.github.danielnasciment.msavaliador.calculador.CalculadorLimite;
import io.github.danielnasciment.msavaliador.domain.enumerateds.BandeiraCartao;

public class CartaoAprovadoResponse {

	private String nomeCartao;
	private BandeiraCartao bandeira;
	private int idadeCliente;
	private BigDecimal limitePreAprovado;

	public CartaoAprovadoResponse(String nomeCartao, BandeiraCartao bandeira, BigDecimal limiteBasico, int idadeCliente) {
		this.nomeCartao = nomeCartao;
		this.bandeira = bandeira;
		this.idadeCliente = idadeCliente;
		this.limitePreAprovado = new CalculadorLimite().calcular(this.idadeCliente, limiteBasico);
	}


	public String getNomeCartao() {
		return nomeCartao;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public int getIdadeCliente() {
		return idadeCliente;
	}

	public BigDecimal getLimitePreAprovado() {
		return limitePreAprovado;
	}



}
