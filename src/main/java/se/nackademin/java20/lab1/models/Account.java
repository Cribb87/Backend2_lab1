package se.nackademin.java20.lab1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by Christoffer Grännby
 * Date: 2021-08-25
 * Time: 09:30
 * Project: Övningsuppgifter
 * Copyright: MIT
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    private long userId;

    @Id
    @GeneratedValue
    private long accountNumber;

    private double balance;

    public Account(long userId, double balance){
        this.userId = userId;
        this.balance = balance;
    }

    public Account(){}

    private void deposit(int amount){
        this.balance += amount;
    }

    private void withdrawal(int amount){
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getUserId() {
        return userId;
    }
}
