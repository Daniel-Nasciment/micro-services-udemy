# micro-services-udemy
Curso Udemy sobre micro services

#

# KEYCLOAK


### Start docker:
> docker run --name keycloak -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.1 start-dev


### REALM 
* Pode ser uma aplicaçao, ou um conjunto de aplicaçoes. Basicamente significa dominio. 


# 

# Dependencia Open API usado nos MS

```pom.xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-ui</artifactId>
  <version>1.6.15</version>
</dependency>
```


