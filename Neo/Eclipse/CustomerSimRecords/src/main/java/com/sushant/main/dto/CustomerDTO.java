package com.sushant.main.dto;

import java.time.LocalDate;
import java.util.List;

import com.sushant.main.model.Sim;

import lombok.Data;

@Data
public class CustomerDTO {

	private Long custId;

	private String Name;

	private String email;

	private String address;

	private LocalDate dateOfBirth;

	private List<Sim> simCards;

}
