package com.divergentsl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divergentsl.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
}
