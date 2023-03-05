package io.github.danielnasciment.mscartoes.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	private String cpf;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Cartao> cartoes;
	
	private BigDecimal limite;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public BigDecimal getLimite() {
		return limite;
	}
	
	
}
