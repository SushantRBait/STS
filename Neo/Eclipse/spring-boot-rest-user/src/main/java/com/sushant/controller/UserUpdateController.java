package com.sushant.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.beans.User;
import com.sushant.beans.UserRegistration;

@RestController
public class UserUpdateController {
	@PutMapping(path="/update/user")
	public String updateStudentRecord(@RequestBody User usrn) {
	System.out.println("In updateStudentRecord");   
	    return UserRegistration.getInstance().upDateUser(usrn);
	}
}
