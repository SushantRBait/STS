package com.sushant.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column
	@Getter
	@Setter
    private Integer departmentId;
   
	@Column
	@Getter
	@Setter
    private String departmentName;
	
	@Column
	@Getter
	@Setter
	private String departmentAddress;
	
	@Column
	@Getter
	@Setter
    private String departmentCode;
		
}
