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

    @GetMapping("/send")
    public String send(@RequestParam String mobile) throws InterruptedException {
    	
    	System.out.println("CALLING 3RD PARTY TO SEND TEXT MESSAGE : " + Thread.currentThread().getName());
        notificationService.sendTextMessage(mobile);
        return "MESSAGE SENT SUCCESSFULLY!!! : " + Thread.currentThread().getName();
        
    }
    
}
