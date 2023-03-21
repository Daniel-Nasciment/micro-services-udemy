package io.github.danielnasciment.mscartoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.danielnasciment.mscartoes.domain.LimiteCartaoCliente;
import io.github.danielnasciment.mscartoes.exception.CpfNotFoundException;
import io.github.danielnasciment.mscartoes.repository.ClienteLimiteRepository;
import io.github.danielnasciment.mscartoes.responseDto.ListCartoesPorCpfResponse;

@Service
public class ClienteLimiteService {

	@Autowired
	private ClienteLimiteRepository clienteLimiteRepository;
	
	
	public ListCartoesPorCpfResponse listCartoesByCpf(String cpf) throws CpfNotFoundException {
		
		List<Optional<LimiteCartaoCliente>> cartoes = clienteLimiteRepository.findByCpf(cpf);
		
		ListCartoesPorCpfResponse response = new ListCartoesPorCpfResponse();
		
		cartoes.forEach(c -> response.toResponse(c));
		
		return response;
		
	}
	
	
}
