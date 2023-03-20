package io.github.danielnasciment.mscartoes.queues;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.danielnasciment.mscartoes.domain.Cartao;
import io.github.danielnasciment.mscartoes.domain.LimiteCartaoCliente;
import io.github.danielnasciment.mscartoes.exception.SolicitacaoCartaoException;
import io.github.danielnasciment.mscartoes.repository.CartaoRepository;
import io.github.danielnasciment.mscartoes.repository.ClienteLimiteRepository;
import io.github.danielnasciment.mscartoes.requestDto.EmissaoCartaoRequest;

@Configuration
@EnableRabbit
public class ListenerEmissaoCartao {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ClienteLimiteRepository clienteLimiteRepository;

	@RabbitListener(queues = "emissao-cartoes")
	public void listenerEmissaoCartoes(@Payload String mensagem) throws Exception {
		
		try {
			EmissaoCartaoRequest request = new ObjectMapper().readValue(mensagem, EmissaoCartaoRequest.class);
			
			Cartao cartao = cartaoRepository.findById(request.getIdCartao()).get();
			
			clienteLimiteRepository.save(new LimiteCartaoCliente(
						request.getCpf(),
						cartao,
						request.getLimiteLiberado()
					));
		} catch (Exception e) {
			throw new SolicitacaoCartaoException("Algo inesperado ocorreu ao tentar configurar limite do cliente.", e);
		}
		
	}
	
	
}
