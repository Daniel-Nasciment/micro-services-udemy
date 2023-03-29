# MS CLIENTE

``` yaml

server:
  port: 0

```

A configuraçao acima garante que a aplicaçao suba em uma porta aleatoria/randomica. Nesse cenário de micro-services nao precisariamos, a cada instancia do ms cliente, definir em qual porta ele irá subir.

``` yaml

eureka:
  client:
    fetch-registry: true
    register-with-eureka: true
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}

```

A configuraçao *client* acima, é para informarmos onde a aplicaçao ira se registrar, no nosso caso, o eureka-server fica em ***http://localhost:8761/eureka***. E a configuraçao *instance* é o nome da instancia que sera registrada no eureka, nesse cenario, utilizamos uma ***expression language*** para concatenar no nome do ms à um valor randomico. De forma que identificaquemos o MS pelo nome, e que o id de instancia seja dinamico.

#

# KEYCLOAK CONFIG CONTAINER

Para fazer com que a aplicação gateway se comunicasse com o keycloak foi preciso fazer uma configuração no admin do keycloak.


No momento que o token é gerado, no momento de validar, o keycloak leva em consideraçao o host e a porta.
Nesse caso foi necessário configurar o ***Frontend URL*** para sobrescrever a *issuer* URL, na sessão *settings realm*.



*URL com **nome** e **porta** do container docker*
>http://keycloak:8080/realms/msrealm