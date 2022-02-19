package com.sushant.main.mail;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Mail {

    private @Getter @Setter String mailFrom;
	
    private @Getter @Setter List<String> mailList;

    private @Getter @Setter String mailSubject;

    private @Getter @Setter String mailContent;

    private @Getter @Setter String contentType;
	
    private @Getter @Setter String[] mailTo;
}
