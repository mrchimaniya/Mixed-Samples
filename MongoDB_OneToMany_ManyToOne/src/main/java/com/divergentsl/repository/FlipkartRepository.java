package com.divergentsl.repository;

import java.util.List; 

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.divergentsl.model.User;

public interface FlipkartRepository extends MongoRepository<User, Integer>{

	List<User> findByName(String name);

	@Query("{'Address.city':?0}")
	List<User> findByCity(String city);
	
	@Query("{'Products.name':?0}")
	List<User> findByProductName(String productName);

}
