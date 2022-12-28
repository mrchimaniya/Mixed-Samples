package com.async.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class AsyncUnCaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
	
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... args) {
    	
        System.out.println("==Error Came== Handler Code Is Executing");
        System.out.println("METHOD NAME "+method.getName()+Arrays.toString(args));
        System.out.println("ERROR MESSAGE: " + ex.getMessage()+"  |THREAD: "+Thread.currentThread().getName());

    }
}
