package com.divergentsl.serviceimpl;

import org.springframework.stereotype.Service;

import com.divergentsl.entity.Account;
import com.divergentsl.exception.InsufficientFundsException;
import com.divergentsl.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Override
	public String withdraw(Account acc, int wd_amt) throws InsufficientFundsException {
	    String status="";
	    if(acc.getBalance()>wd_amt)
	    {
	      System.out.println(acc.getBalance());
	      acc.setBalance(acc.getBalance()-wd_amt);
	      System.out.println("From Withdraw(): Transaction Sucess");
	      status="Sucess";
	      System.out.println(acc.getBalance());
	    } 
	    else
	    {
	      status="Failure";
	      throw new InsufficientFundsException("Funds Are Insufficient");
	    }
		return status;
	}

}
