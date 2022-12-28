package com.async.controller;

import com.async.service.NotificationService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    
    @GetMapping("/sayHello")
    public Future<String> hello() throws InterruptedException, ExecutionException
    {
        System.out.println("\nCALLING 3rd PARTY TO sayHello(), "+ Thread.currentThread().getName());
        
        Future<String> future = notificationService.sayHello();
        
        while (true)
        {
            if (future.isDone())
            {
                System.out.println("RESULT FROM 3RD PARTY - " + future.get()+Thread.currentThread().getName());
                break;
             }
        System.out.println("CONTINUE DOING SOMETHING ELSE... ");
        TimeUnit.SECONDS.sleep(2);
        }
		return future;
    }
}
