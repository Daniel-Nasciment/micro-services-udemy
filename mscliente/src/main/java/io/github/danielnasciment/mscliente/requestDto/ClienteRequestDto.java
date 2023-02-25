package io.github.danielnasciment.mscliente.requestDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.github.danielnasciment.mscliente.domain.Cliente;

public class ClienteRequestDto {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotNull
	private Integer idade;

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public Cliente toModel() {
		return new Cliente(this.nome, this.cpf, this.idade);
	}

}
