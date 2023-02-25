package io.github.danielnasciment.mscliente.controller;

import io.github.danielnasciment.mscliente.exceptions.ClienteNotFoundException;
import io.github.danielnasciment.mscliente.requestDto.ClienteRequestDto;
import io.github.danielnasciment.mscliente.service.ClienteService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> salvarNovoCliente(@RequestBody @Valid ClienteRequestDto request){
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<?> buscarClientePorCpf(@PathVariable(value = "cpf") String cpf) throws ClienteNotFoundException{
        return ResponseEntity.ok(clienteService.buscarClientePorCpf(cpf));
    }

}
