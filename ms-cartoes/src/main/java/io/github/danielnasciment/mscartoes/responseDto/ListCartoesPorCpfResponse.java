package io.github.danielnasciment.mscartoes.responseDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.github.danielnasciment.mscartoes.domain.ClienteLimite;

public class ListCartoesPorCpfResponse {

	private String cpf;
	private BigDecimal limite;
	private List<CartaoResponse> cartoesResponse = new ArrayList<>();


	public String getCpf() {
		return cpf;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public List<CartaoResponse> getCartoesResponse() {
		return cartoesResponse;
	}

	public ListCartoesPorCpfResponse toResponse(ClienteLimite cliente) {

		this.cpf = cliente.getCpf();
		this.limite = cliente.getLimite();
		cliente.getCartoes().forEach(c -> this.cartoesResponse.add(new CartaoResponse().toResponse(c)));

		return this;
	}

}
