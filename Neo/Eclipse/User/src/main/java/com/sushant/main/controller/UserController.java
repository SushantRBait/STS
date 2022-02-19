package com.sushant.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.main.service.UserServices;
import com.sushant.main.VO.ResponseTempleteVO;
import com.sushant.main.model.User;
//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserServices services;

	@PostMapping(path = "/register")
	public User registerUser(@RequestBody User user) {
		services.save(user);
		return user;
	}
	
	@GetMapping("/{id}")
	public ResponseTempleteVO getUserWithDepartment(@PathVariable("id") Integer userId) {
		return services.getUserWithDepartment(userId);	
	}
	
	@GetMapping("/getAll")
	public List<User> list() {
		return services.listAll();
	}
//
//	@GetMapping(path = "/getById/{id}")
//	public ResponseEntity<User> searchUserRecordByName(@PathVariable("id") Integer id) {
//
//		try {
//			User user = services.get(id);
//			System.out.println("In searchUserRecordBy Id");
//			return new ResponseEntity<User>(user, HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@GetMapping(path = "/getByName/{name}")
//	public ResponseEntity<User> searchUserRecordByName(@PathVariable("name") String name) {
//		try {
//			User user = services.getUserRecordByName(name);
//			System.out.println("In searchUserRecordBy Name");
//			return new ResponseEntity<User>(user, HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@PutMapping(path = "/updateByID/{id}")
//	public ResponseEntity<User> updateStudentRecord(@RequestBody User user, @PathVariable Integer id) {
//		try {
//			User existUser = services.get(id);
//			services.save(existUser);
//			return new ResponseEntity<>(HttpStatus.OK);
//
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public void deleteUser(@PathVariable("id") Integer id) {
//		services.delete(id);
//	}
	
}
