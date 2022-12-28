package com.divergentsl.service;

import com.divergentsl.entity.Account;
import com.divergentsl.exception.InsufficientFundsException;

public interface TransactionService {
   
	public String withdraw(Account acc,int wd_amt) throws InsufficientFundsException;
}
