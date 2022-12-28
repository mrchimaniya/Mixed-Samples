package com.divergentsl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.divergentsl.entity.Enrollment;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer>{

}
