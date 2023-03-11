package io.github.danielnasciment.msavaliador.queues;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.danielnasciment.msavaliador.requestDto.CartaoRequest;

@Configuration
@EnableRabbit
public class RabbitConfig {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue queueEmissaoCartoes;
	
	public void solicitaEmissaoCartao(CartaoRequest request) throws JsonProcessingException {
		
		 rabbitTemplate.convertAndSend(
				 queueEmissaoCartoes.getName(), 
				 new ObjectMapper().writeValueAsString(request));
		
	}
	
	@Bean
	public Queue queueEmissaoCartoes() {
		return new Queue("emissao-cartoes", true);
	}
	
}
