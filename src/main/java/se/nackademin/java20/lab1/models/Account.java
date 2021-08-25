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

    private void deposit(int amount){
        this.balance += amount;
    }

    private void withdrawal(int amount){
        if (balance < 0) {
            System.out.println("You can't withdraw " + amount + "\nHere is your current balance: " + balance);
        } else {
            this.balance -= amount;
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
