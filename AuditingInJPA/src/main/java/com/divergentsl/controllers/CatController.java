package com.divergentsl.controllers;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Cat;
import com.divergentsl.repo.CatRepository;

@RestController
public class CatController {
	
	@Autowired
	CatRepository catRepository;

	@PostMapping("/add")
	public ResponseEntity<Cat> add(@RequestBody Cat cat)
	{
		return ResponseEntity.ok(catRepository.save(cat));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cat> update(@RequestBody Cat cat,Authentication authentication)
	{
		return ResponseEntity.ok(catRepository.save(cat));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(Integer id)
	{
		
		
		catRepository.deleteById(id);
		if(catRepository.findById(id) != null)
		{
			return new ResponseEntity<String>("Sucess",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failure",HttpStatus.BAD_REQUEST);
	}
	
	
}
