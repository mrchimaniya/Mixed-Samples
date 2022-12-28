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
    	
    	TimeUnit.SECONDS.sleep(5);
    	
    	System.out.println(10/0); //for exception
    	
        System.out.println("CALLED 3RD PARTY TO SEND TEXT MESSAGE : " + Thread.currentThread().getName());
        
    }
}
