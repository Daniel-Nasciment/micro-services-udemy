package io.github.danielnasciment.msavaliador.responseDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	
}
