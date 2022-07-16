package com.jedisonvieira.balanceservice;

public class Transaction {

    private String id;
    private String accountId;
    private String description;
    private String type;
    private Double value;

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", accountId='" + getAccountId() + "'" +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }

    public boolean isIncome() {
        return type.equals("INCOME");
    }
        
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
