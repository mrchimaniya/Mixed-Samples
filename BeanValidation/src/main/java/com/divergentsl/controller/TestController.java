package com.divergentsl.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.bean.ValidateBean;



@RestController
public class TestController {

	@GetMapping("/")
	public ValidateBean get(@Valid @RequestBody ValidateBean bean)
	{
		return bean;
	}
}
