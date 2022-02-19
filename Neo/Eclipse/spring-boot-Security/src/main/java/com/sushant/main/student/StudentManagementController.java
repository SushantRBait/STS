package com.sushant.main.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/Students/")
public class StudentManagementController {
	
	private static final List<Student> STUDENTS= Arrays.asList(
			new Student(001, "Ram", "Patil", 9876543211L, "@gmail"),
			new Student(002, "Sushant", "Bait", 9876543211L, "@gmail"));
	@GetMapping
	public List<Student> getAllStudents(){
		System.out.println("getAllStudents");
		return STUDENTS;
	}
	@PostMapping
	public void registerNewStudent(@RequestBody Student student) {
		System.out.println("registerNewStudent");
		System.out.println(student);
	}
	@DeleteMapping(path= "{studentId}")
	public void deleteStudent(@PathVariable Integer studentId) {
		System.out.println("deleteStudent");
		System.out.println(studentId);
	}
	@PutMapping(path= "{studentId}")
	public void updateStudent(@PathVariable Integer studentId,@RequestBody Student student) {
		System.out.println("updateStudent");
		System.out.println(String.format("%s %s",studentId,student));
	}
}
