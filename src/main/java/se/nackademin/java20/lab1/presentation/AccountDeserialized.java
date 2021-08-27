package se.nackademin.java20.lab1.presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AccountDeserialized {

    //Tillhör minilabb
    private final String json = "{\"balance\":0,\"holder\":\"Kalle\"\n}";

    private final int balance;
    private final String holder;

    @JsonCreator
    public AccountDeserialized(@JsonProperty("balance") int balance, @JsonProperty("holder") String holder) {
        this.balance = balance;
        this.holder = holder;
    }

    public int getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }


}
