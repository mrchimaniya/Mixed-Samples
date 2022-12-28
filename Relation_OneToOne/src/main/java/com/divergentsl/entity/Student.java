package com.divergentsl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Student {
	  
	  @Id
      private Integer id;
      private String name;
      
      @OneToOne(cascade = CascadeType.ALL)
      //@JoinColumn(name = "enlrollment_no", referencedColumnName = "enroll")  //optional
      @JoinColumn(name="enroll_id") 
     // @JsonIgnore  //if you use this then you can fetch record from enrollment it uses only one side class
      private Enrollment enrollment;

}
