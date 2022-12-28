package com.divergentsl.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InsufficientFundsException extends Exception{
    
   public InsufficientFundsException(String error_msg) {
	super(error_msg);
   }
	
}
