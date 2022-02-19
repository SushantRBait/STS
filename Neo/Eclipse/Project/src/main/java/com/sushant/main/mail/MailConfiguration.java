package com.sushant.main.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Objects;
import java.util.Properties;

@Configuration
@Slf4j
public class MailConfiguration {
	 @Autowired
	    private Environment env;

	    @Bean
	    public JavaMailSender getMailSender() {
	        JavaMailSenderImpl sender = new JavaMailSenderImpl();

	        sender.setHost(env.getProperty("spring.mail.host"));
	        sender.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.mail.port"))));
	        sender.setUsername(env.getProperty("spring.mail.username"));
	        sender.setPassword(env.getProperty("spring.mail.password"));

	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable", "true");
	        javaMailProperties.put("mail.smtp.auth", "true");
	        javaMailProperties.put("mail.transport.protocol", "smtp");
	        javaMailProperties.put("mail.debug", "true");

	        sender.setJavaMailProperties(javaMailProperties);
	        return sender;
	    }
}
