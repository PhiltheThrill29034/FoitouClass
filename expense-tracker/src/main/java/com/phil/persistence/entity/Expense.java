package com.phil.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double amount;

    public Expense(){};

    public Expense(String title, double amount){
        this.title=title;
        this.amount=amount;
    }

    public Long getId(){return this.id;}

    public String getTitle(){return this.title;}

    public double getAmount(){return this.amount;}

    public void setTitle(String title){this.title=title;}

    public void setAmount(double amount){this.amount=amount;}
}
