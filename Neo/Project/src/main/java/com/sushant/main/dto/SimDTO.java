package com.sushant.main.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SimDTO {
	
	private @Getter @Setter Integer SimId;
	
	private @Getter @Setter Long simNo;
	
	private @Getter @Setter String CompanyName;
	
	private @Getter @Setter Long  PUC;  //Personal unblocking code

}

