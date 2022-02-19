package com.sushant.main.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerSimDTO {
	
    private @Getter @Setter Integer custId;

    private @Getter @Setter String Name;

    private @Getter @Setter String email;

    private @Getter @Setter String address;

    private @Getter @Setter String mobileNo;

    private @Getter @Setter LocalDate DOB;
}
