package com.sushant.main.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SimDTO {
	@Setter
	@Getter
	private long simId;

	@Setter
	@Getter
	private long custId;

	@Setter
	@Getter
	private int mobileNo;

	@Setter
	@Getter
	private String company;

	@Setter
	@Getter
	private LocalDate dtOfPurchasing;

}
