package com.sushant.security;

public enum ApplicationUserPermission {
	STUDENT_READ("Student:read"),
	STUDENT_WRITE("Student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	private final String permission;

	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
	
}
