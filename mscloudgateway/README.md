# GATEWAY

## Habilitando na classe principal do projeto

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);
	}

    // RouteLocator -> Fazer o roteamento direto para discovery server, no nosso caso, o eureka.
    // lb://mscliente -> Significa que vai redirecionar para o loadBalancer para o ms cliente.

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
					.route(r -> r.path("/clientes/**").uri("lb://mscliente"))
				.build();
	}
	
}
```