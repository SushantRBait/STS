package com.sushant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.beans.User;
import com.sushant.beans.UserRegistration;
import com.sushant.beans.UserRegistrationReply;

@RestController
public class UserRegistrationController {
		
		  @PostMapping(path="/register/user")
		  public UserRegistrationReply registerUser(@RequestBody User user) {
		  System.out.println("In registerUser");
		  UserRegistrationReply usrregreply = new UserRegistrationReply();           
		  UserRegistration.getInstance().add(user);
		        //We are setting the below value just to reply a message back to the caller
		         usrregreply.setName(user.getName());
		         usrregreply.setSurname(user.getSurname());
		         usrregreply.setPincode(user.getPincode());
		         usrregreply.setDob(user.getDob());
		         usrregreply.setJoinDate(user.getJoinDate());
		         usrregreply.setRegistrationNumber(user.getRegistrationNumber());
		         usrregreply.setRegistrationStatus("Successful");

		        return usrregreply;
		}
}
