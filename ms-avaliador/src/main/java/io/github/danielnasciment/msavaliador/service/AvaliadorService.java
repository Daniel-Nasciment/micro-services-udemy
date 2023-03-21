package io.github.danielnasciment.msavaliador.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danielnasciment.msavaliador.clients.MsCartoesClient;
import io.github.danielnasciment.msavaliador.clients.MsClienteClient;
import io.github.danielnasciment.msavaliador.exeptions.SolicitacaoCartaoException;
import io.github.danielnasciment.msavaliador.queues.SolicitaEmissaoCartaoPublisherRabbitMq;
import io.github.danielnasciment.msavaliador.requestDto.CartaoRequest;
import io.github.danielnasciment.msavaliador.requestDto.DadosAvaliacaoRequest;
import io.github.danielnasciment.msavaliador.responseDto.CartaoAprovadoResponse;
import io.github.danielnasciment.msavaliador.responseDto.CartaoResponse;
import io.github.danielnasciment.msavaliador.responseDto.ClienteResponse;
import io.github.danielnasciment.msavaliador.responseDto.ListCartoesPorCpfResponse;
import io.github.danielnasciment.msavaliador.responseDto.ProtocoloResponse;
import io.github.danielnasciment.msavaliador.responseDto.SituacaoClienteResponse;

@Service
public class AvaliadorService {

	@Autowired
	private MsClienteClient msCliente;
	
	@Autowired
	private MsCartoesClient msCartao;
	
	@Autowired
	private SolicitaEmissaoCartaoPublisherRabbitMq publisherRBMQ;
	
	public SituacaoClienteResponse obterSituacao(String cpf) {
		
		ClienteResponse dadosClienteResponse = msCliente.getDadosCliente(cpf);
		ListCartoesPorCpfResponse cartoesResponse = msCartao.getCartoesByCpf(cpf);
		
		return new SituacaoClienteResponse().toResponse(dadosClienteResponse, cartoesResponse);
	}

	public List<CartaoAprovadoResponse> avaliarCliente(@Valid DadosAvaliacaoRequest request) {

		ClienteResponse cliente = msCliente.getDadosCliente(request.getCpf()); 
		
		List<CartaoResponse> cartoesDisponiveis = msCartao.getCartoesPorRenda(String.valueOf(request.getRenda()));
		
		List<CartaoAprovadoResponse> cartoesAprovados = cartoesDisponiveis.stream().map(c -> {
			
			return new CartaoAprovadoResponse(c.getNome(), c.getBandeira(), c.getLimiteBasico(), cliente.getIdade());
			
		}).collect(Collectors.toList());
		
		return cartoesAprovados;
		
	}
	
	public ProtocoloResponse solicitarCartao(CartaoRequest request) throws SolicitacaoCartaoException {
		
		try {
			publisherRBMQ.solicitaEmissaoCartao(request);
			return new ProtocoloResponse();
		} catch (Exception e) {
			throw new SolicitacaoCartaoException("Algo inesperado ocorreu ao solicitar o cartao.", e);
		}
		
		
	}
	
}