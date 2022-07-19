package com.jedisonvieira.clientesservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Clients extends JpaRepository<Client, Integer> {
    
    Optional<Client> findByCpf(String cpf);

}
