package com.sushant.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.main.model.Department;
import com.sushant.main.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repo;

	private List<Department> departmentRecords;

	private static DepartmentService usrregd = null;

    private DepartmentService(){
    departmentRecords = new ArrayList<Department>();
    }

    public static DepartmentService getInstance() {

        if(usrregd == null) {
        	usrregd = new DepartmentService();
              return usrregd;
            }
            else {
                return usrregd;
            }
    }

    public void add(Department department) {
    	departmentRecords.add(department);
        }
	
	public List<Department> listAll() {
		return repo.findAll();
	}


	public void save(Department department) {
		repo.save(department);
	}

	public Department get(Integer id) {
		return repo.findById(id).get();
	}
    
    
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Department saveDepartment(Department department) {
		
		return repo.save(department);
	}

	public Department findDepartmentById(Integer departmentId) {
	
		return repo.findByDepartmentId(departmentId);
	}

}
