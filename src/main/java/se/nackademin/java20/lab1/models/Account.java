package se.nackademin.java20.lab1.models;

import net.bytebuddy.implementation.bytecode.Throw;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double balance;

    public Account(User user, double balance){
        this.user = user;
        this.balance = balance;
    }

    public Account(){}

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        if (balance > amount){
            this.balance -= amount;
        } else {
            throw new IllegalStateException();
        }

    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }
}
