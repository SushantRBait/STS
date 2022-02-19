package com.sushant.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.main.model.Department;
import com.sushant.main.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		
		return service.saveDepartment(department);
	}
	
	@GetMapping("/getAll")
	public List<Department> list() {
		return service.listAll();
	}

	@GetMapping(path = "/getById/{id}")
	public Department findDepartmentById(@PathVariable("id") Integer departmentId) {

		// try {
		//	Department department = service.get(id);
			System.out.println("In searchUserRecordBy Id");
			//return new ResponseEntity<Department>(department, HttpStatus.OK);
			
			return service.findDepartmentById(departmentId);
//		} catch (NoSuchElementException e) {
//			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			
//		}
	}


	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Department> updateStudentRecord(@RequestBody Department department, @PathVariable Integer id) {
		try {
			Department existDepartment = service.get(id);
			service.save(existDepartment);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		service.delete(id);
	}
	
	
}
