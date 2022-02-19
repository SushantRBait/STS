package com.sushant.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistration {
	@Autowired
	private UserRepository repo;
	
	private List<User> userRecords;

	private static UserRegistration usrregd = null;

	private UserRegistration() {
		userRecords = new ArrayList<User>();
	}

	public static UserRegistration getInstance() {

		if (usrregd == null) {
			usrregd = new UserRegistration();
			return usrregd;
		} else {
			return usrregd;
		}
	}

	public void add(User usr) {
		userRecords.add(usr);
	}

	public String upDateUser(User usr) {
		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
			if (usrn.getRegistrationNumber().equals(usr.getRegistrationNumber())) {
				userRecords.set(i, usr);// update the new record
				return "Update successful";
			}
		}
		return "Update un-successful";
	}

	public String deleteUser(String registrationNumber) {

		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
			if (usrn.getRegistrationNumber().equals(registrationNumber)) {
				userRecords.remove(i);// update the new record
				repo.deleteById(i);
				return "Delete successful";
			}
		}
		return "Delete un-successful";
	}

	public List<User> getUserRecords() {
		
		return userRecords;
	}
//	public List<User> getUserSortRecords(Comparator<? super User> dob) {
//		 userRecords.sort(dob);
//		return userRecords;
//	}

	public User getUserRecordByName(String name) {
		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
		if (usrn.getName().equals(name)) {
			repo.findById(i).get();
			return  userRecords.get(i);
		  }
		}
		//return getUserRecords();
		return null;
	}
	public User getUserRecordBySurname(String surname) {
		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
		if (usrn.getSurname().equals(surname)) {
			return  userRecords.get(i);
		  }
		}
		//return getUserRecords();
		return null;
	}
	
	public User getUserRecordByPincode(int pincode) {
		for (int i = 0; i < userRecords.size(); i++) {
			User usrn = userRecords.get(i);
		if (usrn.getPincode()==(pincode)) {
			return  userRecords.get(i);
		  }
		}
		//return getUserRecords();
		return null;
	}

}
