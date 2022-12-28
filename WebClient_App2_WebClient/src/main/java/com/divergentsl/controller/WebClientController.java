package com.divergentsl.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
import org.springframework.web.reactive.function.client.WebClient;

import com.divergentsl.bean.Dog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webClient")
public class WebClientController {

	private WebClient webClient;

	@PostConstruct
	public void init()
	{
		webClient=WebClient.builder().baseUrl("http://localhost:6060/dog")
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	@PostMapping("/add")
	public Mono<Dog> add(@RequestBody Dog dog)
	{
		return webClient.post().uri("/addDog").bodyValue(dog).retrieve().bodyToMono(Dog.class);
		//return webClient.post().uri("/addDog").syncBody(dog).retrieve().bodyToMono(Dog.class);
		                                        //deprecated		
	}
	
	@GetMapping("/search/{id}")
	public Mono<Dog> search(@PathVariable int id)
	{
		return webClient.get().uri("/searchDog/"+id).retrieve().bodyToMono(Dog.class);
	}
	
	@GetMapping("/getAll")
	public Flux<Dog> getAll()
	{
		return webClient.get().uri("/getAllDog").retrieve().bodyToFlux(Dog.class);
	}
	
	@PutMapping("/update")
	public Mono<Dog> update(@RequestBody Dog dog)
	{
	   return webClient.put().uri("/updateDog").bodyValue(dog).retrieve().bodyToMono(Dog.class);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<String> delete(@PathVariable int id)
	{
		return webClient.delete().uri("/deleteDog/"+id).retrieve().bodyToMono(String.class);
	}

}
