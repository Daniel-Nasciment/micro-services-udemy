package io.github.danielnasciment.mscartoes.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.github.danielnasciment.mscartoes.domain.enumerateds.BandeiraCartao;

@Entity
@Table(name = "CARTOES")
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private BandeiraCartao bandeira;

	private BigDecimal renda;
	
	private BigDecimal limiteBasico;
	
	@Deprecated
	public Cartao() {
	}

	public Cartao(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.renda = renda;
		this.limiteBasico = limiteBasico;
	}

	public Long getId() {
		return id;
	}

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
