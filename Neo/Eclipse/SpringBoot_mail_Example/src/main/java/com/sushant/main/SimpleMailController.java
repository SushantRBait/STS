package com.sushant.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleMailController {
	@Autowired
    private JavaMailSender sender;

    @RequestMapping("/sendMail")
    public String sendMail() {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
       
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate now = LocalDate.now();
		
		LocalDate date = LocalDate.parse("2021-12-30");
		LocalDate then = date.minusDays(7);
		 
		 System.out.println(dtf.format(then));
		
		if (now.compareTo(then) == 0) {
		    
        try {
        	System.out.println("in Try Block");
            helper.setTo("sushantbait93@gmail.com");
            helper.setText("Happy Birthday");
            helper.setSubject("Mail From Spring Boot");
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
		}
        sender.send(message);
        return "Mail Sent Success!";
    }
}
