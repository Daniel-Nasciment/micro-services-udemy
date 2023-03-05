package io.github.danielnasciment.msavaliador.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.danielnasciment.msavaliador.responseDto.ClienteResponse;

@FeignClient(name = "mscliente", path = "/clientes")
public interface MsClienteClient {
	
	@GetMapping(value = "/{cpf}")
	public ClienteResponse getDadosCliente(@PathVariable("cpf") String cpf);

}
