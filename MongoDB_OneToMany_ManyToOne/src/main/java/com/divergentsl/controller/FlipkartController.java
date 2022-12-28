package com.divergentsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.model.User;
import com.divergentsl.repository.FlipkartRepository;


@RestController
@RequestMapping("/orderService")
public class FlipkartController {

	@Autowired
	private FlipkartRepository repository;

	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody User user) {
		repository.save(user);
		return "Order placed successfully...";
	}

	@GetMapping("/getUserByName/{name}")
	public List<User> getUserbyName(@PathVariable String name) {
		return repository.findByName(name);
	}

	@GetMapping("/getUserByCity/{city}")
	public List<User> getUserbyCity(@PathVariable String city) {
		return repository.findByCity(city);
	}
	
	@GetMapping("/getAllUserByProduct/{productName}")
	public List<User> getAllUserByProduct(@PathVariable String productName)
	{
		return repository.findByProductName(productName);
	}

}
