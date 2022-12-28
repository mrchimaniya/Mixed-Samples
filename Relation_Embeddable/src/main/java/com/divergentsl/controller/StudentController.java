package com.divergentsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Address;
import com.divergentsl.entity.Student;
import com.divergentsl.repo.StudentRepo;

@RestController("/")
public class StudentController {
   
	@Autowired
	StudentRepo repository;
	
	@GetMapping
	public String service()
	{
		 Address addr=new Address("101","10th");
		 Student std=new Student(1,"std1",addr);
		 
		 Address addr1=new Address("202","20th");
		 Student std2=new Student(2,"std2",addr1);
		 repository.save(std2);
		 
//	     Student std=new Student(2,"std1");
		 repository.save(std);
		 return "hello";
	}
}