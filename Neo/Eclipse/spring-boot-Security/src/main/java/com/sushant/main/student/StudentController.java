package com.sushant.main.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Students/")
public class StudentController {

	private static final List<Student> STUDENTS= Arrays.asList(
			new Student(001, "Ram", "Patil", 9876543211L, "@gmail"),
			new Student(002, "Sushant", "Bait", 9876543211L, "@gmail"));

	
	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId ) {
		
		
		return STUDENTS.stream().filter(Student -> studentId.equals(Student.getStudentId()))
				.findFirst().orElseThrow(()-> new IllegalStateException("Student "+ studentId +"Does Not exits"));
	}
}
