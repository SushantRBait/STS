package com.sushant.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sushant.main.VO.Department;
import com.sushant.main.VO.ResponseTempleteVO;
import com.sushant.main.model.User;
import com.sushant.main.repository.UserRepository;


@Service
public class UserServices {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RestTemplate restTemplete;
	
	private List<User> userRecords;

	private static UserServices usrregd = null;

    private UserServices(){
    userRecords = new ArrayList<User>();
    }

    public static UserServices getInstance() {

        if(usrregd == null) {
        	usrregd = new UserServices();
              return usrregd;
            }
            else {
                return usrregd;
            }
    }
	
    public void add(User user) {
        userRecords.add(user);
        }
	
	public List<User> listAll() {
		return repo.findAll();
	}

	public List<User> findAll(Sort by) {
		return repo.findAll();
	}

	public void save(User user) {
		repo.save(user);
	}

	public User get(Integer id) {
		return repo.findById(id).get();
	}

	public User getUserRecordByName(String name) {
		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
			if (usrn.getName().equals(name)) {
				repo.findById(i).get();
				return userRecords.get(i);
			}
		}
		return null;
	}

	public User getUserRecordBySurname(String surname) {
		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
			if (usrn.getSurname().equals(surname)) {
				repo.findById(i).get();
				return userRecords.get(i);
			}
		}
		return null;
	}

	public User getUserRecordByPincode(Integer pincode) {
		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
			if (usrn.getPincode() == (pincode)) {
				repo.findById(i).get();
				return userRecords.get(i);
			}
		}
		return null;
	}

	public void delete(Integer id) {
		repo.deleteById(id);
		}

	public ResponseTempleteVO getUserWithDepartment(String registrationNumber) {
		ResponseTempleteVO vo=new ResponseTempleteVO();
		User user= repo.findById(registrationNumber);

//		Department department=
//					restTemplete.getForObject("localhost:9001/departments/"+ user.getDepartmentId() ,Department.class)
		
		return null;
	}
	
}
