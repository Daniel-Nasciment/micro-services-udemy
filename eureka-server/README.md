# DISCOVERY-SERVER EUREKA SERVER

Os micro-services se registram nele. Como podemos ter muitas instancias de um unico MS, devemos sempre definir um nome para o MS.

### Configuraçoes importantes sao feitas nos seguintes arquivos:

arquivo de configuraçao, nesse caso: ***application.yml***
classe principal anotada com @SpringBootApplication, nesse caso: ***EurekaServerApplication***

#### Por convençao, o eureka é configurado na porta 8761, atravez do localhost:8761 temos acesso ao painel gerencial do eureka server.

#

As seguintes configuraçoes sao feitas para que o eureka nao se registre nele mesmo, e que nao seja responsabilidade deles procurar os registros dos micro-services:

``` yaml
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false

```

#

## HABILITANDO SPRING SECURITY E CONFIGURANDO *SecurityFilterChain*

#### link para documentaçao without WebSecurityConfigurerAdapter:

> https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

```pom.xml
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```


``` yaml
spring:
  security:
      user:
        name: user
        password: password

```

```java

@EnableWebSecurity
public class SecurityWebConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            )
            .httpBasic();
        
        return http.build();
    }

}


```

