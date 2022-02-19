package com.sushant.main.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerDTO {

	private @Getter @Setter Integer custId;

	private @Getter @Setter String name;

	private @Getter @Setter String Address;

	private @Getter @Setter String email;

	private @Getter @Setter LocalDate DOB;

}
