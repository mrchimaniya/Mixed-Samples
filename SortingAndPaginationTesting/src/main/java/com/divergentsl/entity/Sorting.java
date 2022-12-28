package com.divergentsl.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Sorting {
      @Id
      private int id;
      private int rollno;
      private String name;

}
