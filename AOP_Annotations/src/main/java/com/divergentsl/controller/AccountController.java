package com.divergentsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Account;
import com.divergentsl.exception.InsufficientFundsException;
import com.divergentsl.service.TransactionService;

@RestController
public class AccountController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public String get() throws InsufficientFundsException
	{
		Account acc=new Account();
		acc.setAccno(111);
		acc.setAccname("Hello");
		acc.setBalance(10000);
		String status = transactionService.withdraw(acc,500);
		//String status = transactionService.withdraw(acc,500000);  //for genration exception
		return status;
		
	}
}
