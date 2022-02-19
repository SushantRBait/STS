package com.sushant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.beans.User;
import com.sushant.beans.UserRegistration;

@RestController
public class UserRetrieveController {
	
	  @GetMapping(path="/user/allusers") 
	  public List<User> getAllUsers() {
		  System.out.println("In All User records");   
		  return UserRegistration.getInstance().getUserRecords();
	  }
	
		@GetMapping(path="/user/name/{name}") 
		public User searchUserRecordByName(@PathVariable("name") String name) {
			System.out.println("In searchUserRecordBy Name");   
		    return UserRegistration.getInstance().getUserRecordByName(name);
		}

		@GetMapping(path="/user/surname/{sname}") 
		public User searchUserRecordBySurname(@PathVariable("sname") String sname) {
			System.out.println("In searchUserRecordBy Surname");   
		    return UserRegistration.getInstance().getUserRecordBySurname(sname);
		}
		
		@GetMapping(path="/user/surname/{pincode}") 
		public User searchUserRecordByPincode(@PathVariable("pincode") int pincode) {
		System.out.println("In searchUserRecordBy Pincode");   
		    return UserRegistration.getInstance().getUserRecordByPincode(pincode);
		}
}
