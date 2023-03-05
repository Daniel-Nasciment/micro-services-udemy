package io.github.danielnasciment.mscartoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danielnasciment.mscartoes.domain.Cliente;
import io.github.danielnasciment.mscartoes.exception.ClienteNotFoundException;
import io.github.danielnasciment.mscartoes.repository.ClienteRepository;
import io.github.danielnasciment.mscartoes.responseDto.ClienteCartaoResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public ClienteCartaoResponse listCartoesByCpf(String cpf) throws ClienteNotFoundException {
		
		Optional <Cliente> cliente = clienteRepository.findByCpf(cpf);
		
		if(cliente.isPresent()) {
			return new ClienteCartaoResponse().toResponse(cliente.get());
		}
	
		throw new ClienteNotFoundException("Cliente não encontrado!");
	
	}
	
	
}
