package com.divergentsl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.divergentsl.bean.Dog;
import com.divergentsl.repo.DogRepo;

@RestController
@RequestMapping("/dog")
public class DogController {

	@Autowired
	DogRepo dogRepo;
	
	@PostMapping("/addDog")
	public Dog addDog(@RequestBody Dog dog)
	{
		return dogRepo.save(dog);
	}
	
	@GetMapping("/searchDog/{id}")
	public Dog searchDog(@PathVariable int id)
	{
		return dogRepo.findById(id).get();
	}
	
	@GetMapping("/getAllDog")
	public List<Dog> getAllDog()
	{
		return dogRepo.findAll();
	}
	
	@PutMapping("/updateDog")
	public Dog updateDog(@RequestBody Dog dog)
	{
	 return dogRepo.save(dog);
	}
	
	@DeleteMapping("/deleteDog/{id}")
	public String deleteDog(@PathVariable int id)
	{
		dogRepo.deleteById(id);
		return "Id "+id+" Dog Deleted Sucess";
	}

}
