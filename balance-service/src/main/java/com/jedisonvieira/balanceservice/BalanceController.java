package com.jedisonvieira.balanceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BalanceController {

    private final Balances balances;

    @Autowired
    public BalanceController(Balances balances) {
        this.balances = balances;
    }

    @GetMapping(value = "/balance-service/balances", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findByAccountId(@RequestParam String accountId) {
        final var balanceOptional = balances.findByAccountId(accountId);
        final var returnMap = new HashMap<String, Object>();
        returnMap.put("os.name", System.getenv().getOrDefault("HOSTNAME", "unknown"));
        balanceOptional.ifPresent(balance -> returnMap.put("balance", balance));
        return ResponseEntity.status(HttpStatus.OK).body(returnMap);
    }

}