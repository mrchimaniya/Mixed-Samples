package com.divergentsl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divergentsl.entity.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{
}
