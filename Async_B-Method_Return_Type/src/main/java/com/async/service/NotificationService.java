package com.async.service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    //@Async
    public Future<String> sayHello() throws InterruptedException {
    	
        System.out.println("EXECUTE sayHello() METHOD FROM 3rd Party : "+ Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        return new AsyncResult<String>("HELLO WORLD !!!!");
        
       }
}
