package com.sushant.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.main.data.model.Student;
import com.sushant.main.data.model.dto.StudentDto;
import com.sushant.main.service.StudentServices;

@RestController
@RequestMapping("/Students/api")
public class StudentController {
  
  private StudentServices studentServices;
  
    @Autowired
	public StudentController(StudentServices studentServices) {
	this.studentServices = studentServices;
}
	
	@PostMapping("/insert")
	//@PreAuthorize("hasAuthority('student:read')")
	public ResponseEntity<StudentDto> addProject(@RequestBody final StudentDto studentdto) {
		Student student =studentServices.save(Student.from(studentdto));
		return new ResponseEntity<>(StudentDto.from(student),HttpStatus.OK);
	}
	@GetMapping("/getAll")
//	@PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_ADMIN')")
	public List<Student> list() {
		return studentServices.listAll();
	}

	@GetMapping(path = "/getDetails/{studentId}")
	public ResponseEntity<Student> searchUserRecordByName(@PathVariable("studentId") Integer studentId) {

		try {
			Student student = studentServices.getStudent(studentId);
			System.out.println("In searchUserRecordBy Id");
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
