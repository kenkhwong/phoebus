package com.example.phoebus.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private List<Customer> customers;

    @NotNull(message = "Account number is mandatory")
    @Column(unique = true)
    private int accountNumber;

    public Account() {}

    public Account(List<Customer> customers, int accountNumber) {
        this.customers = customers;
        this.accountNumber = accountNumber;
    }

    public long getId() {
        return id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
