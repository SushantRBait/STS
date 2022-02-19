package com.sushant.main.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Mail {

	@Setter
	@Getter
    private String mailFrom;
	
	@Setter
	@Getter
    private List<String> mailList;

	@Setter
	@Getter
    private String mailSubject;

	@Setter
	@Getter
    private String mailContent;

	@Setter
	@Getter
    private String contentType;

	@Setter
	@Getter
    private String[] mailTo;
}
