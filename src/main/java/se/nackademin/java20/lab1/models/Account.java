package se.nackademin.java20.lab1.models;

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

    public Account(User userId, double balance){
        this.user = userId;
        this.balance = balance;
    }

    public Account(){}

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withdraw(double amount){
        this.balance -= amount;
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
