package com.jian.lcapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.jian.lcapp.validator.NotExist;

public class LoginDTO {

	@NotEmpty(message = "{email.empty}")
	@Email(message = "{email.valid}")
	@NotExist(message = "{email.notExist}")
	private String email;
	
	@NotEmpty(message = "{password.empty}")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
