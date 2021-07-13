package com.example.phoebus.model;

import com.example.phoebus.constraints.Alphabetic;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "customers")
    private List<Account> accounts;

    @NotBlank(message = "Forename is mandatory")
    @Alphabetic(message = "Forename must be alphabetic")
    private String forename;

    @NotBlank(message = "Surname is mandatory")
    @Alphabetic(message = "Surname must be alphabetic")
    private String surname;

    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Date of birth must be a past date")
    private LocalDate dateOfBirth;

    public Customer() {}

    public Customer(String forename, String surname, LocalDate dateOfBirth) {
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
