package com.divergentsl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hello")
	public ResponseEntity<String> hello()
	{
	
	    int a=10/0;
		return new ResponseEntity<String>("Sucess Without Exception",HttpStatus.OK);
	}
}
