package com.example.phoebus.service;

import com.example.phoebus.model.Account;
import com.example.phoebus.model.Customer;
import com.example.phoebus.repository.AccountRepository;
import com.example.phoebus.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public void addAccount(List<Customer> customers, int accountNumber) {
        accountRepository.save(new Account(customers, accountNumber));
    }

    @Transactional
    public void addAccount(long customerId, int accountNumber) {
        addAccount(List.of(customerRepository.findById(customerId).orElseThrow()), accountNumber);
    }

    @Transactional(readOnly = true)
    public List<Customer> getCustomers(int accountNumber) {
        return List.copyOf(accountRepository.findByAccountNumber(accountNumber).orElseThrow()
                .getCustomers());
    }

    @Transactional(readOnly = true)
    public List<Account> getAccounts(long customerId) {
        return List.copyOf(customerRepository.findById(customerId).orElseThrow()
                .getAccounts());
    }
}
