package io.github.danielnasciment.mscliente.responseDto;

import io.github.danielnasciment.mscliente.domain.Cliente;

public class ClienteResponse {
    
	private static final String MESSAGE_SUCCESS = "Cliente encontrado!";
	private String nome;
    private String cpf;
    private int idade;
    
    private String message;
    

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ClienteResponse toResponse(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.idade = cliente.getIdade();
        this.message = MESSAGE_SUCCESS;
        return this;
    }

}
