package com.divergentsl.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Enrollment {

  @Id
  private int enroll;
  private String collegename;
 
  
  @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "enrollment")
  @JsonIgnore		    //it is use to prevent circular read and now you can fetch record from student  it uses only one class
  private Student std; 
 
}
