package com.main.sushant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.sushant.VO.Department;
import com.main.sushant.VO.ResponseTempleteVO;
import com.main.sushant.model.User;
import com.main.sushant.repository.UserRepository;


@Service
public class UserServices {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RestTemplate restTemplete;
//	
//	private List<User> userRecords;
//
//	private static UserServices usrregd = null;

//    private UserServices(){
//    userRecords = new ArrayList<User>();
//    }
//
//    public static UserServices getInstance() {
//
//        if(usrregd == null) {
//        	usrregd = new UserServices();
//              return usrregd;
//            }
//            else {
//                return usrregd;
//            }
//    }
//	
//    public void add(User user) {
//        userRecords.add(user);
//        }
	
	public List<User> listAll() {
		return repo.findAll();
	}

//	public List<User> findAll(Sort by) {
//		return repo.findAll();
//	}

	public void save(User user) {
		repo.save(user);
	}

//	public User get(Integer StudentId) {
//		return repo.findById(StudentId).get();
//	}
//
//	public User getUserRecordByName(String name) {
//		for (int i = 0; i < userRecords.size(); i++) {
//			User usrn = userRecords.get(i);
//			if (usrn.getName().equals(name)) {
//				repo.findById(i).get();
//				return userRecords.get(i);
//			}
//		}
//		return null;
//	}
//
//
//	public void delete(Integer id) {
//		repo.deleteById(id);
//		}

	public ResponseTempleteVO getUserWithDepartment(Integer userId) {
		ResponseTempleteVO vo=new ResponseTempleteVO();
		User user= repo.findByUserId(userId);
		Department department=restTemplete.getForObject("http://localhost:9002/user/get/"+user.getDepartmentId(), Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
				
		return vo;
	}


	
}
