package com.divergentsl.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Enrollment;
import com.divergentsl.entity.Student;
import com.divergentsl.repo.EnrollmentRepo;
import com.divergentsl.repo.StudentRepo;

@RestController("/")
public class StudentController {
 
	@Autowired
	StudentRepo stdRepo;

	@Autowired
	EnrollmentRepo enrollRepo;
	
    @GetMapping("/adduni")
	public String services() {
		
		Enrollment enroll = new Enrollment();
		enroll.setEnroll(1111);
		enroll.setCollegename("prestige");
		  Student std = new Student();
		  std.setId(1);
		  std.setName("aayush");
		  std.setEnrollment(enroll);
		stdRepo.save(std);  
		
		 Enrollment enroll2 = new Enrollment();
		 enroll2.setEnroll(2222);
		 enroll2.setCollegename("Malwa");
			  Student std2 = new Student();
			  std2.setId(2);
			  std2.setName("ram");
			  std2.setEnrollment(enroll2);
	    stdRepo.save(std2);
		return "sucess";
	} 
    
    @GetMapping("/deleteuni")
	public String deleteu() {
        stdRepo.deleteById(2);
        return "sucess";
    }


 /*   @GetMapping("/addbi")
	public String service() {
    	Student std = new Student();
	    std.setId(2);
	    std.setName("aayush");
	    	Enrollment enroll = new Enrollment();
			enroll.setEnroll(1111);
			enroll.setCollegename("prestige");
		std.setEnrollment(enroll);
		enroll.setStd(std);
		enrollRepo.save(enroll);
		return "sucess";
    }
	*/

	
	@GetMapping("/reads")
	public List<Student> reads()
	{
		List<Student> std = stdRepo.findAll();
		return std;
	}
	
/*	@GetMapping("/reade")
	public Enrollment reade()
	{
		Optional<Enrollment> enroll=enrollRepo.findById(1111);
		return enroll.get() ;
	}  */  //reading from enrollment;
}