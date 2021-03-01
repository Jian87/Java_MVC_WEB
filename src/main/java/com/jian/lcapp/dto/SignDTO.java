package com.jian.lcapp.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.jian.lcapp.validator.Exist;

public class SignDTO {

	@NotEmpty(message = "{sign.in.firstname}")
	private String firstName;
	
	@NotEmpty(message = "{sign.in.lastname}")
	private String lastName;
	
	@NotEmpty(message = "{password.empty}")
	@Size(min = 6, max = 10, message = "{sign.in.password.size}")
	private String password;
	
	@NotEmpty(message = "{email.empty}")
	@Email(message = "{email.valid}")
	@Exist(message="{email.exist}")
	private String email;
	
	@NotEmpty(message = "{sign.in.gender.empty}")
	private String gender;
	
	@AssertTrue(message = "{termAndCondition.disagree}")
	private boolean termAndCondition;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	@Override
	public String toString() {
		return "SignDTO [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", email="
				+ email + ", gender=" + gender + ", termAndCondition=" + termAndCondition + "]";
	}
}
