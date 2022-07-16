package com.jedisonvieira.balanceservice;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "last_transaction_id")
    private String lastTransactionId;

    @Column(name = "account_id")
    private String accountId;
    
    private Double value;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastTransactionId() {
        return this.lastTransactionId;
    }

    public void setLastTransactionId(String lastTransactionId) {
        this.lastTransactionId = lastTransactionId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastTransactionId='" + getLastTransactionId() + "'" +
            ", accountId='" + getAccountId() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
    

    public Balance(String lastTransactionId, String accountId, Double value) {
        this.lastTransactionId = lastTransactionId;
        this.accountId = accountId;
        this.value = value;
    }

    public Balance() {
    }

}
