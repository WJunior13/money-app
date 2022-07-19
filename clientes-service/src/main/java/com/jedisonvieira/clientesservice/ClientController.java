package com.jedisonvieira.clientesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@RestController
public class ClientController {

    private final Clients clients;

    @Autowired
    public ClientController(Clients clients) {
        this.clients = clients;
    }

    @GetMapping(value = "/clientes-service/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findByCpf(@RequestParam String cpf) {
        final var clientOptional = clients.findByCpf(cpf);
        final var returnMap = new HashMap<String, Object>();
        returnMap.put("os.name", System.getenv().getOrDefault("HOSTNAME", "unknown"));
        clientOptional.ifPresent(client -> returnMap.put("client", client));
        return ResponseEntity.status(HttpStatus.OK).body(returnMap);
    }

    @PostMapping(value = "/clientes-service/clientes/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Client client) {
        if (nonNull(client)) {
            clients.save(client);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}