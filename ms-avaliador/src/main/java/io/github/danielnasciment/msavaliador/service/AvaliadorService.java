package io.github.danielnasciment.msavaliador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danielnasciment.msavaliador.clients.MsCartoesClient;
import io.github.danielnasciment.msavaliador.clients.MsClienteClient;
import io.github.danielnasciment.msavaliador.responseDto.ClienteResponse;
import io.github.danielnasciment.msavaliador.responseDto.ListCartoesPorCpfResponse;
import io.github.danielnasciment.msavaliador.responseDto.SituacaoClienteResponse;

@Service
public class AvaliadorService {

	@Autowired
	private MsClienteClient msCliente;
	
	@Autowired
	private MsCartoesClient msCartao;
	
	public SituacaoClienteResponse obterSituacao(String cpf) {
		
		ClienteResponse dadosClienteResponse = msCliente.getDadosCliente(cpf);
		ListCartoesPorCpfResponse cartoesResponse = msCartao.getCartoesByCpf(cpf);
		
		return  new SituacaoClienteResponse().toResponse(dadosClienteResponse, cartoesResponse);
	}
	
}
