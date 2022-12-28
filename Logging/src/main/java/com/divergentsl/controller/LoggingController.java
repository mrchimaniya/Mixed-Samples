package com.divergentsl.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoggingController {

	@GetMapping("/")
	public ResponseEntity<String> logging()
	{
		log.debug("Logging Method Called");
		return ResponseEntity.ok("Logged In");
	}
}
