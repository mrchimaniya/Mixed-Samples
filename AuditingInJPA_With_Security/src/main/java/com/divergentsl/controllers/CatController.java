package com.divergentsl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Cat;
import com.divergentsl.repo.CatRepository;

@RestController
public class CatController {
	
	@Autowired
	CatRepository catRepository;
	
	@GetMapping("/add")
	public ResponseEntity<Cat> aaa()
	{   
		Cat cat=new Cat();
		cat.setName("yy");
		return ResponseEntity.ok(catRepository.save(cat));
	}

	
	@GetMapping("/update")
	public ResponseEntity<Cat> update()
	{
		Cat cat=new Cat();
		cat.setId(2);
		cat.setName("ll");
		return ResponseEntity.ok(catRepository.save(cat));
	}
	

	
	
}
