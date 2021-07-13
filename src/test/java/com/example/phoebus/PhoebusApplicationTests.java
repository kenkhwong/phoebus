package com.example.phoebus;

import com.example.phoebus.model.Account;
import com.example.phoebus.model.Customer;
import com.example.phoebus.repository.AccountRepository;
import com.example.phoebus.repository.CustomerRepository;
import com.example.phoebus.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PhoebusApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountService accountService;

	@Test
	void contextLoads() {}

	@Test
	void testAccountService() {
		//Preload customers
		customerRepository.save(new Customer("Ann", "Lee", LocalDate.now().minusDays(1)));
		customerRepository.save(new Customer("Ben", "Kong", LocalDate.now().minusDays(1)));
		customerRepository.save(new Customer("Tom", "Lo", LocalDate.now().minusDays(1)));

		//Add accounts
		List<Customer> customers = customerRepository.findAll();
		accountService.addAccount(customers, 12345);
		accountService.addAccount(customers, 23456);

		accountService.addAccount(1L, 9876);

		//Get customers with account number
		List<Customer> accountCustomers = accountService.getCustomers(12345);
		assertEquals(customers.stream().map(Customer::getId).collect(Collectors.toSet()),
				accountCustomers.stream().map(Customer::getId).collect(Collectors.toSet()));

		accountCustomers = accountService.getCustomers(9876);
		assertEquals(1, accountCustomers.size());
		assertEquals(1L, accountCustomers.get(0).getId());

		//Get accounts with customer Id
		List<Account> accounts = accountRepository.findAll();
		List<Account> customerAccounts = accountService.getAccounts(1L);
		assertEquals(accounts.stream().map(Account::getId).collect(Collectors.toSet()),
				customerAccounts.stream().map(Account::getId).collect(Collectors.toSet()));
	}
}
