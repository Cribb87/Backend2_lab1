package se.nackademin.java20.lab1.models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;

    public int age;

    public User(){}

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

}
