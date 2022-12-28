package com.async.service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
    @Async
    public Future<String> sayHello() throws InterruptedException {
    	
    	System.out.println("execute service  logic before sleep : "+ Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(10);
        int i=10/0;
        System.out.println("after 10 sec service sleep complete");
           //Arithmetic Exception
        
        return new AsyncResult<String>("HELLO WORLD !!!!");
        
       }
}
