package com.async.controller;

import com.async.service.NotificationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
 
    
    @GetMapping("/sayHello")
    public String hello() throws InterruptedException, ExecutionException
    {  String result="";
    	 System.out.println("Call controller method :, "+ Thread.currentThread().getName());
         
         Future<String> future = notificationService.sayHello();
         if(future.isDone())
         {
        	 result="result from service ";
         }
         List<String> error=null;
     try {
        if(future==null)
        {
        	
         	throw new CustomeException("200 somthingwrong");
            
        }
     }catch( CustomeException ex) {
    	 
   	  error=new ArrayList<String>();        
         error.add("ServiceDown:"+ ex.getMessage());
    }
       catch(Exception ex) {
    	 
    	  error=new ArrayList<String>();        
          error.add("ServiceDown:"+ ex.getMessage());
     }
    
         result="result from controller:"+error.get(0);
 		return result;
    }
    
  
}




class CustomeException extends RuntimeException{
	   String errorcode;
	   String errormsg;
	   CustomeException(String msg){
		   super(msg);
	   }
	   
	   }
