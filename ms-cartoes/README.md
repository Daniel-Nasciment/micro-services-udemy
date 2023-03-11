# MS CARTÕES

### Dica importante para query methods no spring data jpa:

Buscar na documentação as expressões que traduzem a query em SQL

> Seção: Query creation

> Link para documentação: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

#

## PASSO A PASSO CRIAÇAO DE SUBSCRIBER PARA RABBITMQ

#### *DEPENDENCIAS:*

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


#### *YML CONFIGURATION*

```yaml
spring: 
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```


#### *CRIANDO RABBIT LISTENER*

```java

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


```