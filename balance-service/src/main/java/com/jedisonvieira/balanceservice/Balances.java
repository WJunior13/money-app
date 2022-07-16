package com.jedisonvieira.balanceservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Balances extends JpaRepository<Balance, Integer> {
    
    Optional<Balance> findByAccountId(String accountId);

}
