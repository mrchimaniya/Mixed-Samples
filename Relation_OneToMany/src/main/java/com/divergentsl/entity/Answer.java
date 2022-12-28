package com.divergentsl.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Answer {

  @Id
  private int aid;
  private String answer;
 
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="q_id")
   @JsonIgnore
   private Question question;

}
