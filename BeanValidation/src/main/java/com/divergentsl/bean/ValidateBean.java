package com.divergentsl.bean;

import javax.validation.constraints.NotEmpty; 
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ValidateBean {
	

	@NotEmpty(message = "Bean Should Not Be Null")
	private String phone;
	
	@Size(max = 2,message = "Size Should Be More Than 2")
	private String name;
	
}
