package se.nackademin.java20.lab1.models;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User userId;

    private double balance;

    public Account(User userId, double balance){
        this.userId = userId;
        this.balance = balance;
    }

    public Account(){}

    private void deposit(int amount){
        this.balance += amount;
    }

    private void withdrawal(int amount){
        this.balance -= amount;
        if (balance < 0) {
            System.out.println("You can't withdraw " + amount + "\nHere is your current balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public long getAccountId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }
}
