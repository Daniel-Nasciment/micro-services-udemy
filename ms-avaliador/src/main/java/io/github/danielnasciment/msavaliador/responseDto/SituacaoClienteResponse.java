package io.github.danielnasciment.msavaliador.responseDto;

public class SituacaoClienteResponse {

	private ClienteResponse cliente;
	private ListCartoesPorCpfResponse clienteCartoes;

	public ClienteResponse getCliente() {
		return cliente;
	}
	
	public ListCartoesPorCpfResponse getClienteCartoes() {
		return clienteCartoes;
	}

	public void setCliente(ClienteResponse cliente) {
		this.cliente = cliente;
	}

	public void setClienteCartoes(ListCartoesPorCpfResponse clienteCartoes) {
		this.clienteCartoes = clienteCartoes;
	}

	public SituacaoClienteResponse toResponse(ClienteResponse dadosClienteResponse, ListCartoesPorCpfResponse cartoesResponse) {
		
		this.cliente = dadosClienteResponse;
		this.clienteCartoes = cartoesResponse;

		return this;
	}
	
	
}
