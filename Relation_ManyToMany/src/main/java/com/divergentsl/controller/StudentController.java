package com.divergentsl.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Employee;
import com.divergentsl.entity.Project;
import com.divergentsl.repo.EmployeeRepo;
import com.divergentsl.repo.ProjectRepo;

@RestController("/")
public class StudentController {
 
	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	EmployeeRepo empRepo;
	
    @GetMapping("/adduni")
	public String services() {
      //one employee has 2 project	
    	Employee emp1=new Employee();
    	emp1.setEid(1);
    	emp1.setName("aayush");
    	
    	Project p1=new Project();
    	p1.setPid(111);
    	p1.setPname("Facebook");
    	
    	Project p2=new Project();
    	p2.setPid(222);
    	p2.setPname("Netflix");
    	
    	List<Project> list2=new ArrayList<Project>();
    	list2.add(p1);
    	list2.add(p2);
        emp1.setProject(list2);
        
        List<Employee> list1=new ArrayList<Employee>();
        list1.add(emp1);
        p1.setEmployee(list1);
        p2.setEmployee(list1);
        
        //1 project has 2 employee    	
    	Employee emp3=new Employee();
     	emp3.setEid(2);
     	emp3.setName("ram");
    	
    	Project p3=new Project();
    	p3.setPid(222);
    	p3.setPname("Netflix");
    	
    	List<Project> list4=new ArrayList<>();
    	list4.add(p3);
    	emp3.setProject(list4);
    	
    	List<Employee> list3=new ArrayList<>();
    	list3.add(emp3);
    	p3.setEmployee(list3);
    	
    	
    	  empRepo.save(emp1);
          empRepo.save(emp3);
        
        
    	return "Sucess";		
	} 
	
    
	 @GetMapping("/addbi")
	 public String service() {
	        Project p1=new Project();
	        p1.setPid(111);
	        p1.setPname("Facebook");
	        
	        Project p2=new Project();
	        p2.setPid(222);
	        p2.setPname("Netflix");
	        
	        Employee e1=new Employee();
	        e1.setEid(1);
	        e1.setName("Aayush");
	        
	        List<Project> list1=new ArrayList<Project>();
	        list1.add(p1);
	        list1.add(p2);
	        
	        List<Employee> list2=new ArrayList<Employee>();
	        list2.add(e1);
	        
	        p1.setEmployee(list2);
	        p2.setEmployee(list2);
	        
	        e1.setProject(list1);
	  
	        
	        List<Project> list3=new ArrayList<Project>();
	        list3.add(p2);
	        
	        Employee e2=new Employee();
	        e2.setEid(2);
	        e2.setName("ram");
	        e2.setProject(list3);
	        
	        List<Employee> list4=new ArrayList<Employee>();
	        list2.add(e2);
	        p2.setEmployee(list4);
	        
	        
	        projectRepo.save(p1);
	        projectRepo.save(p2);			  
	    	 
	    	return "Sucess";		
		} 
	 


	
	@GetMapping("/reads")
	public List<Project> reads()
	{
		List<Project> project = projectRepo.findAll();
		return project;
	}
	
	@GetMapping("/reade")
	public List<Employee> reade()
	{
	    List<Employee> employee = empRepo.findAll();
	    return employee;
	}
}