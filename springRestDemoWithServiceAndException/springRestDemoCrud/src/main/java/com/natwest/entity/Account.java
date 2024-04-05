package com.natwest.entity;

import jakarta.persistence.*;

@Entity
@Table(name="account_tbl")
public class Account {
    @Id  //this should be from jakarta package
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", unique = true)
    private String name;
    private double balance;
    private String accountType;
    public Account(){

    }
    public Account(int id,String name, double balance, String accountType) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
