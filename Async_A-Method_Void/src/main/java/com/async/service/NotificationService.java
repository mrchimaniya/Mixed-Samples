package com.async.service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
    @Async
    public void sendTextMessage(String mobile) throws InterruptedException {
    	//demo code for 3rd party service provider
    	TimeUnit.SECONDS.sleep(8);
    	
        System.out.println("CALLED 3RD PARTY TO SEND TEXT MESSAGE : " + Thread.currentThread().getName());
    }
  
}
