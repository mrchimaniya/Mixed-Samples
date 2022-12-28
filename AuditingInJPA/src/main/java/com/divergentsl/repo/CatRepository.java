package com.divergentsl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.divergentsl.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer>{

}
