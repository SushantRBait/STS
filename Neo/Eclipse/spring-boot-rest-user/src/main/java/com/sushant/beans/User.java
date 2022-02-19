package com.sushant.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	 @Column
	 String registrationNumber;
	 @Column
	 String name;
	 @Column
	 String surname;
	 @Column
	 int pincode;
	 @Column
	 Date dob;
	 @Column
	 Date joinDate;	 
	 
	public User() {
		super();
	}

	public User(String registrationNumber, String name, String surname, int pincode, Date dob, Date joinDate) {
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.surname = surname;
		this.pincode = pincode;
		this.dob = dob;
		this.joinDate = joinDate;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
