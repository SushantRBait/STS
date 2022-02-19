package com.sushant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.beans.User;
import com.sushant.beans.UserRegistration;

@RestController
public class UserSortController {
	
	@GetMapping(path="/user/sort/dob") 
	public User searchUserRecordByPincode(@PathVariable("pincode") int pincode) {
	System.out.println("In Sort UserRecord By Date of Birth");   
	    return UserRegistration.getInstance().getUserRecordByPincode(pincode);
	}
}
