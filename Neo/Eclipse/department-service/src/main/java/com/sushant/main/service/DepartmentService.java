 package com.sushant.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.main.model.Department;
import com.sushant.main.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}
	
	public Department findDepatmentById(Integer departmentId) {
	
		return departmentRepository.findDepartmentById(departmentId);
	}

	
}
