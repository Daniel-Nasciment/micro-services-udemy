# MS AVALIADOR

### Dica importante para open feign:

Normalmente definimos a interface do feign da seguinte forma:

```java

@FeignClient(name = "mscliente", url = "http://url.fake.com")
public interface MsClienteClient {
	
	@GetMapping(value = "/{cpf}")
	public ClienteResponse getDadosCliente(@PathVariable("cpf") String cpf);

}

```

No cenário de micro serviços já é um pouco diferente, se definirmos uma URL, não será feito o balanceamento de carga. E nesse projeto, não é o objetivo.

Repare que, o *name* definido, é o nome exato do micro serviço de clientes.

```java
@FeignClient(name = "mscliente")
```

Então, para definirmos que, o Feign vai no micro serviço correto, pelo gateway com o balanceamento de carga. definimos a interface da seguinte forma:


```java

@FeignClient(name = "mscliente", path = "/clientes")
public interface MsClienteClient {
	
	@GetMapping(value = "/{cpf}")
	public ClienteResponse getDadosCliente(@PathVariable("cpf") String cpf);

}

```
