package io.github.danielnasciment.msavaliador.requestDto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaoRequest {

	@NotNull
	private Long idCartao;

	@NotBlank
	private String cpf;

	@NotNull
	private String endereco;

	@NotNull
	private BigDecimal limiteLiberado;

	public Long getIdCartao() {
		return idCartao;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getLimiteLiberado() {
		return limiteLiberado;
	}

}
