package com.divergentsl.apects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.divergentsl.entity.Account;
import com.divergentsl.exception.InsufficientFundsException;

@Component 
@Aspect
public class TransactionAspects {
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	  
	@Before("execution(* com.divergentsl.service.TransactionService.*(..))")
	public void before(JoinPoint joinPoint)
	{
		Object[] params=joinPoint.getArgs();
		Account account=(Account)params[0];
		logger.warn("BEFORE ADVICE: Initial Balance: "+account.getBalance());		
	}
	
	@After("execution(* com.divergentsl.service.TransactionService.*(..))")
	public void after(JoinPoint joinPoint)
	{
		Object[] params=joinPoint.getArgs();
		Account account=(Account)params[0];
		logger.warn("AFTER ADVICE: Initial Balance: "+account.getBalance());		
	}
	
	@AfterReturning(pointcut="execution(* com.divergentsl.service.TransactionService.*(..))",returning = "result" )
	public void afterReturning(JoinPoint joinPoint,Object result)
	{
		Object[] params=joinPoint.getArgs();
		Account account=(Account)params[0];
		logger.warn("AFTER RETURNING: Transaction Status: "+result);		
	}
	
	@Around("execution(* com.divergentsl.service.TransactionService.*(..))")
	public void around(ProceedingJoinPoint proceedingJoinPoint)
	{
		logger.warn("AROUND ADVICE(BEFORE): "+proceedingJoinPoint.getSignature().getName()+" METHOD EXECUTION");
		String status="";
		try {
			  status = (String)proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		logger.warn("AROUND ADVICE(AFTER): "+proceedingJoinPoint.getSignature().getName()+" METHOD EXECUTION");	
		logger.warn("AROUND ADVICE: Transaction Status: "+status);
	}
	
	@AfterThrowing(pointcut = "execution(* com.divergentsl.service.TransactionService.*(..))",throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint,Exception exception)
	{
		logger.warn("AFTER THROWING: "+exception.getClass().getName()+" In Transaction: "+exception.getMessage());
	}
}
