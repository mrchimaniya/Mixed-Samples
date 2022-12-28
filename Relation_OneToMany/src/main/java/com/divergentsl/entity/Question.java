package com.divergentsl.entity;

import java.util.List;

import javax.persistence.CascadeType; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data 
public class Question {
	  
	  @Id
      private Integer id;
      private String question;
      
//      @JsonIgnore
      @OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
              //if you don'nt use mappedBy then it will create an extra table in database that is not necessary
      private List<Answer> answer;  

}
