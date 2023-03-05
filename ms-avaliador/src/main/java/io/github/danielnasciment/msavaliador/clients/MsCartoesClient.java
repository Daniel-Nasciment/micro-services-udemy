package io.github.danielnasciment.msavaliador.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.danielnasciment.msavaliador.responseDto.ListCartoesPorCpfResponse;

@FeignClient(name = "mscartoes", path = "/cartoes")
public interface MsCartoesClient {

	@GetMapping(value = "/listCartoes/{cpf}")
	public ListCartoesPorCpfResponse getCartoesByCpf(@PathVariable("cpf") String cpf);
	
}
