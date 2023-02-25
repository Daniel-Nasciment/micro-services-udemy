package io.github.danielnasciment.mscliente.controller;

import io.github.danielnasciment.mscliente.requestDto.ClienteRequestDto;
import io.github.danielnasciment.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> salvarNovoCliente(@RequestBody ClienteRequestDto request){
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<?> buscarClientePorCpf(@PathVariable(value = "cpf") String cpf){
        return ResponseEntity.ok().build();
    }

}
