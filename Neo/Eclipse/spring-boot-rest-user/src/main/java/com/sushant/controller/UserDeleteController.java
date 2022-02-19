package com.sushant.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.beans.UserRegistration;

@RestController
public class UserDeleteController {
	@DeleteMapping(path="/delete/user/{regdNum}")
	public String deleteUserRecord(@PathVariable("regdNum") String regdNum) {
	System.out.println("In deleteUserRecord");   
	    return UserRegistration.getInstance().deleteUser(regdNum);
	}
}
