package com.jedisonvieira.balanceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class TransactionsReceiver {

    private final Balances balances;

    @Autowired
    public TransactionsReceiver(Balances balances) {
        this.balances = balances;
    }

    @RabbitListener(queues = "transactions")
    public void receiveTransaction(byte[] jsonInBytes) {
        final var gson = new Gson();
        final var transaction = gson.fromJson(new String(jsonInBytes), Transaction.class);
        System.out.println("Receiving message: " + transaction.toString());
        var balanceOptional = balances.findByAccountId(transaction.getAccountId());
        if (balanceOptional.isPresent()) {
            final var balance = balanceOptional.get();
            balance.setValue(transaction.isIncome() ? 
                balance.getValue() + transaction.getValue() :
                balance.getValue() - transaction.getValue()
            );
            balance.setLastTransactionId(transaction.getId());
            System.out.println("Storing balance: " + balance.toString());
            balances.save(balance);
        } else {
            final var factor = transaction.isIncome() ? 1 : -1;
            final var balance = new Balance(transaction.getId(), transaction.getAccountId(), transaction.getValue() * factor);
            System.out.println("Storing balance: " + balance.toString());
            balances.save(balance);
        }        
    }

}