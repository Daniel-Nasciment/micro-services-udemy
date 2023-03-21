package io.github.danielnasciment.mscartoes.responseDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.github.danielnasciment.mscartoes.domain.LimiteCartaoCliente;

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

	public void toResponse(Optional<LimiteCartaoCliente> possivelCartao) {

		if(possivelCartao.isPresent()) {
			LimiteCartaoCliente cartao = possivelCartao.get();
			this.cpf = cartao.getCpf();
			this.limite = cartao.getLimite();
			this.cartoesResponse.add(new CartaoResponse().toResponse(cartao.getCartao()));
		}
		
	}

}
