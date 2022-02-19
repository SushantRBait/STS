package com.sushant.main.mail;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sushant.main.controller.CustomerController;

@Service("mailServices")
public class MailSenderService {
	  
	@Autowired
	    JavaMailSender mailSender;
	   
		Logger logger = LoggerFactory.getLogger(CustomerController.class);

	    public void sendEmail(Mail mail) {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();

	        try {

	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	            logger.info("Sending mails...");
	            helper.setSubject(mail.getMailSubject());
	            helper.setFrom(new InternetAddress(mail.getMailFrom()));
	            helper.setTo(mail.getMailTo());
	            helper.setText(mail.getMailContent());
	            logger.info("Mails sent.");
	            mailSender.send(helper.getMimeMessage());

	        } catch (MessagingException e) {
	            logger.error("Mails not sent..");
	            e.printStackTrace();
	        }
	    }

}
