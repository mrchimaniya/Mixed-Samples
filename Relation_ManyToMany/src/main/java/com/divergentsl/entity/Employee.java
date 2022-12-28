package com.divergentsl.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Employee {

  @Id
  private int eid;
  private String name;
 
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name="employee_project",joinColumns={ @JoinColumn(name="eid") } , inverseJoinColumns={@JoinColumn(name="pid")})
//   @JsonIgnore
   private List<Project> project;

}
