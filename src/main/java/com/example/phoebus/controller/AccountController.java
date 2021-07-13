package com.example.phoebus.controller;

import com.example.phoebus.model.Account;
import com.example.phoebus.model.Customer;
import com.example.phoebus.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    ResponseEntity<String> newAccount(@RequestParam long customerId, @RequestParam int accountNumber) {

        accountService.addAccount(customerId, accountNumber);

        return ResponseEntity.created(URI.create("/accounts")).build();
    }

    @GetMapping("/customers")
    List<Customer> getCustomers(@RequestParam int accountNumber) {
        return accountService.getCustomers(accountNumber);
    }

    @GetMapping("/accounts")
    List<Account> getAccounts(@RequestParam long customerId) {
        return accountService.getAccounts(customerId);
    }
}
