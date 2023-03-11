package io.github.danielnasciment.mscartoes.queues;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@EnableRabbit
public class RabbitConfig {

	@RabbitListener(queues = "emissao-cartoes")
	public void listenerEmissaoCartoes(@Payload String mensagem) {
		System.out.println(mensagem);
	}
	
	
}
