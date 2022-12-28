package com.divergentsl.entity;

import java.util.List;

import javax.persistence.CascadeType; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data 
public class Project {
	  
	  @Id
      private Integer pid;
      private String pname;
      
      @ManyToMany(cascade = CascadeType.ALL, mappedBy = "project")
      @JsonIgnore
      private List<Employee> employee;

}
