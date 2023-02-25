package io.github.danielnasciment.mscliente.service;

import io.github.danielnasciment.mscliente.domain.Cliente;
import io.github.danielnasciment.mscliente.exceptions.ClienteNotFoundException;
import io.github.danielnasciment.mscliente.repository.ClienteRepository;
import io.github.danielnasciment.mscliente.responseDto.ClienteResponse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteResponse salvarNovoCliente(Cliente cliente){
       return new ClienteResponse().toResponse(clienteRepository.save(cliente));
    }

    public ClienteResponse buscarClientePorId(String cpf) throws ClienteNotFoundException{

        Optional<Cliente> possivelCliente = clienteRepository.findByCpf(cpf);
        
        if(possivelCliente.isPresent()) {
        	return new ClienteResponse().toResponse(possivelCliente.get());
        }

        throw new ClienteNotFoundException("Cliente not found");
    }

}
