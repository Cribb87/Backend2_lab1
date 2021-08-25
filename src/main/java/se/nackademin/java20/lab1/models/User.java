package se.nackademin.java20.lab1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Christoffer Grännby
 * Date: 2021-08-25
 * Time: 09:42
 * Project: Övningsuppgifter
 * Copyright: MIT
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column
    public String name;

    @Column
    public int age;

    public User(){}

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
}
