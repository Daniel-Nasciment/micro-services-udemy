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