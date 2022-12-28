package com.divergentsl.entity;

import javax.annotation.PreDestroy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cat extends Audit{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  

	 @PrePersist
	  public void prePersist()
	  {
		  System.out.println("prePersist");
	  }
	  
	  @PreUpdate
	  public void preUpdate()
	  {
		  System.out.println("preUpdate");
	  }
	  
	  @PreRemove
	  public void preRemove()
	  {
		  System.out.println("preRemove");
	  }
  
}
