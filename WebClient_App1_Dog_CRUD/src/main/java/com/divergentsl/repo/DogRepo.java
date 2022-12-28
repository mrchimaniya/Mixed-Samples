package com.divergentsl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divergentsl.bean.Dog;

public interface DogRepo extends JpaRepository<Dog, Integer> {

}
