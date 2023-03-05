package io.github.danielnasciment.mscartoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danielnasciment.mscartoes.domain.ClienteLimite;
import io.github.danielnasciment.mscartoes.exception.CpfNotFoundException;
import io.github.danielnasciment.mscartoes.repository.ClienteLimiteRepository;
import io.github.danielnasciment.mscartoes.responseDto.ListCartoesPorCpfResponse;

@Service
public class ClienteLimiteService {

	@Autowired
	private ClienteLimiteRepository clienteLimiteRepository;
	
	
	public ListCartoesPorCpfResponse listCartoesByCpf(String cpf) throws CpfNotFoundException {
		
		Optional <ClienteLimite> clienteLimiteECartoes = clienteLimiteRepository.findByCpf(cpf);
		
		if(clienteLimiteECartoes.isPresent()) {
			return new ListCartoesPorCpfResponse().toResponse(clienteLimiteECartoes.get());
		}
	
		throw new CpfNotFoundException("CPF não encontrado!");
	
	}
	
	
}
