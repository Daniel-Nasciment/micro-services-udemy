package io.github.danielnasciment.mscliente.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.danielnasciment.mscliente.exceptions.ClienteNotFoundException;
import io.github.danielnasciment.mscliente.requestDto.ClienteRequestDto;
import io.github.danielnasciment.mscliente.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> salvarNovoCliente(@RequestBody @Valid ClienteRequestDto request){
    	clienteService.salvarNovoCliente(request.toModel());
        return ResponseEntity.created(ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{cpf}")
        		.buildAndExpand(request.getCpf()).toUri())
        		.build();
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<?> buscarClientePorCpf(@PathVariable(value = "cpf") String cpf) throws ClienteNotFoundException{
        return ResponseEntity.ok(clienteService.buscarClientePorCpf(cpf));
    }

}
