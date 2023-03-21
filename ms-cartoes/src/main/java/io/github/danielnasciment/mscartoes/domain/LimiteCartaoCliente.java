package io.github.danielnasciment.mscartoes.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIMITE_CARTAO_CLIENTE")
public class LimiteCartaoCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cartao cartao;
	
	private BigDecimal limite;
	
	@Deprecated
	public LimiteCartaoCliente() {
	}

	public LimiteCartaoCliente(String cpf, Cartao cartao, BigDecimal limite) {
		this.cpf = cpf;
		this.cartao = cartao;
		this.limite = limite;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public BigDecimal getLimite() {
		return limite;
	}
	
}
