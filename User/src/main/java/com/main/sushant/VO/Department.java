package com.main.sushant.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@AllArgsConstructor
@NoArgsConstructor

public class Department {
	
	private Integer departmentId;
   
    private String departmentName;
	
	private String departmentAddress;
	
	private String departmentCode;

	   
}