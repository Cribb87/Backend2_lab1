package se.nackademin.java20.lab1.models;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
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
        if (balance < 0) {
            System.out.println("You can't withdraw " + amount + "\nHere is your current balance: " + balance);
        } else {
            this.balance -= amount;
        }
    }

}
