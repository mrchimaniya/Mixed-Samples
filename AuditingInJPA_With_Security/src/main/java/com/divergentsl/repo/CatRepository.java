package com.divergentsl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divergentsl.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer>{

}
