# micro-services-udemy
Curso Udemy sobre micro services

#

# KEYCLOAK


### Start docker:
> docker run --name keycloak -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.1 start-dev

# 

### INTEGRAÇÃO ENTRE CONTAINERS (MY SQL, EUREKA, ETC)

Um ponto de atenção:

Quando a aplicação precisa se conectar a um database, no caso desse projeto atravéz de containers, é preciso fazer algumas configurações:


1º - A partir da versão do spring boot 2.7.9 podemos utilizar o conector do mysql 8.***:
```pom.xml
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.27</version>
</dependency>
```
#

2º Baixar e configurar o container do mysql:

O comando que eu utilizei foi:

> docker run mysql-container --network my-network -e MYSQL_ROOT_PASSWORD=*password* mysql:8.0.27

Após isso, entrar em modo interativo com o bash do mysql para criação do database:

> docker exec -it *id-container* bash

Ao entrar em modo iterativo:
>  mysql -u root -p

Adicione a senha definida na variavel do docker run e execute os comandos SQL necessários.

Lembre-se também de fazer a configuração do dialeto do banco de dados para garantir o funcionamento correto dos scripts SQL:

```yml 

spring:
  jpa:
     properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect

```

#

3º Configuração no application. yml/properties

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://mysql-container:3306/dbmicroservices
```

Repare na url do datasource, onde temos *mysql-container*. Como estamos subindo as instancias em containers docker na mesma rede, o docker é inteligente o suficiente para ler o nome do container *"mysql-container"* e fazer a comunicação via DNS.

Seguido todas os passos acima, o resultado esperado é que os containers estejam conversão entre si e a aplicação se concte com sucesso ao mysql.



