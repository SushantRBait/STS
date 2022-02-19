package com.sushant.main.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerSimDTO {
	@Setter
	@Getter
    private Long custId;

	@Setter
	@Getter
    private String Name;

	@Setter
	@Getter
    private String email;

	@Setter
	@Getter
    private String address;

	@Setter
	@Getter
    private String mobileNo;

	@Setter
	@Getter
    private LocalDate dateOfBirth;
}
