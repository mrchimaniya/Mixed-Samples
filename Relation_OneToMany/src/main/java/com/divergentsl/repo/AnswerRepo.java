package com.divergentsl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divergentsl.entity.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer>{

}
