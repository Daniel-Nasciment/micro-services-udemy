# MS AVALIADOR CREDITO

## MS CARTOES FOI CRIANDO UM PUBLISHER:

#### *DEPENDENCIAS ADICIONADAS:*

```pom.xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.amqp</groupId>
	<artifactId>spring-rabbit-test</artifactId>
	<scope>test</scope>
</dependency>
```

#

#### *YML CONFIGURATION*

```yaml
spring: 
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

#

#### *CRIANDO RABBIT PUBLISHER*

```java

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


```