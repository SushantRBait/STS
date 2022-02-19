package com.sushant.main.VO;

import com.sushant.main.model.User;

public class ResponseTempleteVO {

	private User user;
	private Department department;
	public ResponseTempleteVO() {
		
	}
	
	public ResponseTempleteVO(User user, Department department) {
		
		this.user = user;
		this.department = department;
	}


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
